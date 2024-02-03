package com.decrypto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MercadoRequest {

    private MercadoDTO mercado;
    private Set<Long> comitenteIds;
}
