package com.decrypto.controller;

import com.decrypto.dto.MercadoRequest;
import com.decrypto.entity.Mercado;
import com.decrypto.service.MercadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mercados")
public class MercadoController {
    @Autowired
    private MercadoService mercadoService;

    @Operation(summary = "Create mercado")
    @PostMapping
    public ResponseEntity<Mercado> createMercado(@RequestBody MercadoRequest mercado) {
        Mercado createdMercado = mercadoService.createMercado(mercado);
        return new ResponseEntity<>(createdMercado, HttpStatus.CREATED);
    }
    @Operation(summary = "Return all")
    @GetMapping
    public ResponseEntity<List<Mercado>> getAllMercados() {
        return new ResponseEntity<>(mercadoService.getAllMercados(), HttpStatus.OK);
    }

    @Operation(summary = "Return mercado by id ")
    @GetMapping("/{id}")
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        return new ResponseEntity<>(mercadoService.getMercadoById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercado) {
        return new ResponseEntity<>(mercadoService.updateMercado(id, mercado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteMercado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
