package com.decrypto.dto;

import com.decrypto.entity.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MercadoDTO {

    @NotNull(message = "codigo no debe ser nulo")
    @NotEmpty(message = "codigo no debe estar en blanco")
    private String codigo;
    @NotNull(message = "descripcion no debe ser nulo")
    private String descripcion;
    @NotNull(message = "pais no debe ser nulo")
    private Long pais;
}
