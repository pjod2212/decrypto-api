package com.decrypto.service;


import com.decrypto.dto.MercadoRequest;
import com.decrypto.entity.Comitente;
import com.decrypto.entity.Mercado;
import com.decrypto.entity.Pais;
import com.decrypto.exception.NotFoundException;
import com.decrypto.repository.ComitenteRepository;
import com.decrypto.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private ComitenteRepository comitenteRepository;

    public Mercado createMercado(MercadoRequest mercadoRequest) {
        List<Comitente> comitentes = comitenteRepository.findAllById(mercadoRequest.getComitenteIds());

        if(comitentes.size() != mercadoRequest.getComitenteIds().size()) {
            throw new NotFoundException("Alguno de los comitentes especificados no existe");
        }

        return mercadoRepository.save(requestMapper(mercadoRequest, comitentes));
    }

    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id).orElseThrow(() -> new NotFoundException("Comitente no encontrado"));
    }

    public Mercado updateMercado(Long id, Mercado mercado) {
        if (mercadoRepository.existsById(id)) {
            mercado.setId(id);
            return mercadoRepository.save(mercado);
        } else {
            throw new NotFoundException("No se puede encontrar el mercado con ID: " + id);
        }
    }

    public void deleteMercado(Long id) {
        mercadoRepository.deleteById(id);
    }

    public Mercado requestMapper(MercadoRequest mercadoRequest, List<Comitente> comitentes) {
        return  Mercado.builder()
                .codigo(mercadoRequest.getMercado().getCodigo())
                .pais(Pais.builder()
                        .id(mercadoRequest.getMercado().getPais())
                        .build())
                .descripcion(mercadoRequest.getMercado().getDescripcion())
                .comitentes(new HashSet<>(comitentes))
                .build();
    }

}
