package com.decrypto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mercado_comitente")
public class MercadoComitente {
    @Id
    @Column(name = "mercado_id")
    private Long mercadoId;

    @Column(name = "comitente_id")
    private Long comitenteId;

}
