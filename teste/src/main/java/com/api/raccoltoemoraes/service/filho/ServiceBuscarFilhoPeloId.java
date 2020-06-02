package com.api.raccoltoemoraes.service.filho;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryFilho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarFilhoPeloId {
    @Autowired
    private RepositoryFilho repositoryFilho;

    public Filho buscarFilhoPeloId(Long id) {

        if (repositoryFilho.findById(id).isPresent() & repositoryFilho.findById(id) != null) {
            return repositoryFilho.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Filho não está registrado nos nossos registros");
        }
    }
}
