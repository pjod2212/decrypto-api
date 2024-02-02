package com.decrypto.service;

import com.decrypto.entity.Comitente;
import com.decrypto.exception.DuplicateComitenteException;
import com.decrypto.exception.NotFoundException;
import com.decrypto.repository.ComitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComitenteService {

    @Autowired
    private ComitenteRepository comitenteRepository;

    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAll();
    }

    public Comitente getComitenteById(Long id) {
        return comitenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Comitente no encontrado"));
    }

    public Comitente createComitente(Comitente comitente) {
        try {
            return comitenteRepository.save(comitente);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateComitenteException("Ya existe un Comitente con la misma descripción");
        }
    }

    public Comitente updateComitente(Long id, Comitente comitenteDetails) {
        Optional<Comitente> optionalComitente = comitenteRepository.findById(id);
        if (optionalComitente.isPresent()) {
            Comitente comitente = optionalComitente.get();
            comitente.setDescripcion(comitenteDetails.getDescripcion());
            // También podrías manejar las relaciones si es necesario
            return comitenteRepository.save(comitente);
        } else {
            throw new NotFoundException("No se encuentra el comitente");
        }
    }

    public void deleteComitente(Long id) {
        comitenteRepository.deleteById(id);
    }

}
