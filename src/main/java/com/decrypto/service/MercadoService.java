package com.decrypto.service;


import com.decrypto.dto.DistribucionComitentesDTO;
import com.decrypto.dto.MercadoRequestDTO;
import com.decrypto.entity.Comitente;
import com.decrypto.entity.Mercado;
import com.decrypto.exception.DuplicateMercadoException;
import com.decrypto.exception.NotFoundException;
import com.decrypto.mapper.Mapper;
import com.decrypto.repository.ComitenteRepository;
import com.decrypto.repository.DistribucionComitentesRepository;
import com.decrypto.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private ComitenteRepository comitenteRepository;

    @Autowired
    private DistribucionComitentesRepository distribucionComitentesRepository;

    @Autowired
    private Mapper mapper;

    public Mercado create(MercadoRequestDTO mercadoRequestDTO) {
        Optional<Set<Long>> comitentesRequest = Optional.ofNullable(mercadoRequestDTO.getComitentes());

        List<Comitente> comitentes = comitentesRequest.map(ids -> comitenteRepository.findAllById(ids))
                .orElseGet(Collections::emptyList);

        comitentesRequest.ifPresent(ids -> {
            if (comitentes.size() != ids.size()) {
                throw new NotFoundException("Alguno de los comitentes especificados no existe");
            }
        });

        Optional<Mercado> mercado = mercadoRepository.findByCodigo(mercadoRequestDTO.getMercado().getCodigo());

        if( mercado.isPresent() ) {
            throw new DuplicateMercadoException("El mercado ya existe");
        }

        return mercadoRepository.save(mapper.createMercado(mercadoRequestDTO, comitentes));
    }

    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id).orElseThrow(() -> new NotFoundException("Comitente no encontrado"));
    }

    public Mercado updateMercado(MercadoRequestDTO mercado) {

        Optional.ofNullable(mercado.getMercado().getId()).orElseThrow(() ->
                new NotFoundException("El id de mercado no puede ser nulo"));

        if (mercadoRepository.existsById(mercado.getMercado().getId())) {
            Optional<Set<Long>> comitentesRequest = Optional.ofNullable(mercado.getComitentes());

            List<Comitente> comitentes = comitentesRequest.map(ids -> comitenteRepository.findAllById(ids))
                    .orElseGet(Collections::emptyList);

            comitentesRequest.ifPresent(ids -> {
                if (comitentes.size() != ids.size()) {
                    throw new NotFoundException("Alguno de los comitentes especificados no existe");
                }
            });

            return mercadoRepository.save(mapper.updateMercado(mercado,comitentes));
        } else {
            throw new NotFoundException("No se puede encontrar el mercado con ID: " + mercado.getMercado().getId());
        }
    }

    public void deleteMercado(Long id) {
        mercadoRepository.deleteById(id);
    }

    public List<DistribucionComitentesDTO> stats() {
        return this.mapper.fillDistribucionComitentes(distribucionComitentesRepository.stats());
    }

}
