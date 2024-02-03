package com.decrypto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "comitente")
public class Comitente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String descripcion;

    @JsonIgnore
    @ManyToMany(mappedBy = "comitentes")
    private Set<Mercado> mercados = new HashSet<>();

    // Constructor, getters y setters
}
