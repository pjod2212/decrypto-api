package com.decrypto.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@Entity
@Table(name = "mercado")
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codigo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToMany
    @JoinTable(name = "mercado_comitente",
            joinColumns = @JoinColumn(name = "mercado_id"),
            inverseJoinColumns = @JoinColumn(name = "comitente_id"))
    private Set<Comitente> comitentes = new HashSet<>();

    // Constructor, getters y setters
}

