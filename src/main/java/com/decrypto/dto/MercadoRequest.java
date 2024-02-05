package com.decrypto.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoRequest {
    @Valid
    private MercadoDTO mercado;
    private Set<Long> comitentes;
}
