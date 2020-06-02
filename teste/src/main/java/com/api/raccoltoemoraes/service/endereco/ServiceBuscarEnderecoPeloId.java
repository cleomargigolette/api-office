package com.api.raccoltoemoraes.service.endereco;

import com.api.raccoltoemoraes.domain.Endereco;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarEnderecoPeloId {
    @Autowired
    private RepositoryEndereco repositoryEndereco;

    public Endereco buscarEnderecoPeloId(Long id) {

        if (repositoryEndereco.findById(id).isPresent()) {
            return repositoryEndereco.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Endereço não cadastrado");
        }

    }
}
