package com.decrypto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.decrypto.entity.Mercado;
import com.decrypto.service.MercadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MercadoControllerTest {

    @Mock
    private MercadoService mercadoService;

    @InjectMocks
    private MercadoController mercadoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMercadoById() {
        // Mock de un objeto Mercado y su ID
        Long mercadoId = 1L;
        Mercado mercado = Mercado.builder().id(mercadoId).build();

        when(mercadoService.getMercadoById(mercadoId)).thenReturn(mercado);

        ResponseEntity<Mercado> responseEntity = mercadoController.getMercadoById(mercadoId);

        // Verificar que el código de estado de la respuesta sea OK (200)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verifico que el id devuelto sea el enviado
        assertEquals(mercadoId, responseEntity.getBody().getId());
    }
}

