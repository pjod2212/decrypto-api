package com.decrypto.repository;

import com.decrypto.entity.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
}
