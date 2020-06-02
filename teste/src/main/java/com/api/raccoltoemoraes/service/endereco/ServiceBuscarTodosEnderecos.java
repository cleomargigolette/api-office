package com.api.raccoltoemoraes.service.endereco;

import com.api.raccoltoemoraes.domain.Endereco;
import com.api.raccoltoemoraes.repository.RepositoryEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodosEnderecos {

    @Autowired
    private RepositoryEndereco repositoryEndereco;

    public List<Endereco> buscarTodosEnderecos() {
        return repositoryEndereco.findAll();
    }
}
