package com.decrypto.repository;

import com.decrypto.entity.MercadoComitente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistribucionComitentesRepository extends JpaRepository<MercadoComitente, Long> {

    @Query(value = "SELECT p.nombre AS country, m.codigo AS market, " +
            "COUNT(mc.comitente_id) / (SELECT COUNT(*) FROM mercado_comitente) * 100 AS percentage " +
            "FROM mercado_comitente mc " +
            "JOIN mercado m ON mc.mercado_id = m.id " +
            "JOIN comitente c ON mc.comitente_id = c.id " +
            "JOIN pais p ON m.pais_id = p.id " +
            "GROUP BY p.nombre, m.descripcion", nativeQuery = true)
    List<Tuple> stats();

}
