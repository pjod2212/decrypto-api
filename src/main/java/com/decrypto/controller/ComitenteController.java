package com.decrypto.controller;

import com.decrypto.entity.Comitente;
import com.decrypto.service.ComitenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comitentes")
public class ComitenteController {

    @Autowired
    private ComitenteService comitenteService;

    @Operation(summary = "Return all comitentes")
    @GetMapping
    public ResponseEntity<List<Comitente>> getAllComitentes() {
        return new ResponseEntity<>(comitenteService.getAllComitentes(), HttpStatus.OK);
    }

    @Operation(summary = "Return comitente by id")
    @GetMapping("/{id}")
    public ResponseEntity<Comitente> getComitenteById(@PathVariable Long id) {
       return new ResponseEntity<>(comitenteService.getComitenteById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create comitente")
    @PostMapping
    public ResponseEntity<Comitente> createComitente(@RequestBody Comitente comitente) {
        return new ResponseEntity<>(comitenteService.createComitente(comitente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comitente> updateComitente(@PathVariable Long id, @RequestBody Comitente comitenteDetails) {
        return new ResponseEntity<>(comitenteService.updateComitente(id, comitenteDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComitente(@PathVariable Long id) {
        comitenteService.deleteComitente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
