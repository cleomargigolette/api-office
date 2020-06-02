package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarMaePeloId {
    @Autowired
    private RepositoryMae repositoryMae;

    public Mae buscarMaePeloId(Long id) {

        if (repositoryMae.findById(id).isPresent() & repositoryMae.findById(id) != null) {
            return repositoryMae.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Mae não está registrada.");
        }
    }
}
