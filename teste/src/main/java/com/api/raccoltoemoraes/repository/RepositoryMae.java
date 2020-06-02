package com.api.raccoltoemoraes.repository;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.domain.Mae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryMae extends JpaRepository<Mae, Long> {
    @Query("SELECT m FROM Mae m WHERE m.ativo = true")
    List<Mae> buscarTodasMaesAtivas();

    @Query("SELECT f FROM Filho f WHERE f.mae = ?1")
    List<Filho> buscarTodosFilhosMae(Mae mae);

    @Query("SELECT m FROM Mae m where m.cpf = ?1 AND m.primeiroNome = ?2")
    Optional<Mae> findByCpf(Long cpf, String primeiroNome);}
