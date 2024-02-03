package com.decrypto.dto;

import com.decrypto.entity.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MercadoDTO {

    private String codigo;

    private String descripcion;

    private Long pais;
}
