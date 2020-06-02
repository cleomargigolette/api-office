package com.api.raccoltoemoraes.repository;

import com.api.raccoltoemoraes.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEndereco extends JpaRepository<Endereco, Long> {
}
