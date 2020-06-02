package com.api.raccoltoemoraes.repository;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Mae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryConsultor extends JpaRepository<Consultor, Long> {
    Optional<Consultor> findByEmail(String email);

    @Query("SELECT m FROM Consultor m WHERE m.ativo = true")
    List<Consultor> buscarTodosConsultorAtivos();

    @Query("SELECT m FROM Mae m WHERE m.consultor = ?1 AND m.ativo = true")
    List<Mae> buscarTodasMaesConsultor(Consultor consultor);

    @Query("SELECT c FROM Consultor c where c.id = ?1 AND c.ativo = true")
    Optional<Consultor> findByIdAtivo(Long id);
}
