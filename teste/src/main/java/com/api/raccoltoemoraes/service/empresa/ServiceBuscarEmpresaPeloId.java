package com.api.raccoltoemoraes.service.empresa;

import com.api.raccoltoemoraes.domain.Empresa;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarEmpresaPeloId {

    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    public Empresa buscarEmpresaPeloId(Long id) {

        if (repositoryEmpresa.findById(id).isPresent()) {
            return repositoryEmpresa.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Empresa não cadastrada.");
        }

    }

}

