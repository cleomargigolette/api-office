package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarConsultorPeloID {
    @Autowired
    private RepositoryConsultor repositoryConsultor;

    public Consultor buscaPeloId(Long id) {

        if (repositoryConsultor.findById(id).isPresent() & repositoryConsultor.findById(id) != null) {
            return repositoryConsultor.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Consultor não está registrado");
        }
    }
}
