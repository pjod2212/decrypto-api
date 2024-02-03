package com.decrypto.repository;

import com.decrypto.entity.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {

    Optional<Mercado> findByCodigo(String codigo);

}
