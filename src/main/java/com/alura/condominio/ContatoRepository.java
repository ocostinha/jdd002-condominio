package com.alura.condominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, String> {
    Optional<ContatoEntity> findByCpf(String cpf);
}
