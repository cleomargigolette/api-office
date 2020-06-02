package com.api.raccoltoemoraes.repository;

import com.api.raccoltoemoraes.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresa extends JpaRepository<Empresa, Long> {
}
