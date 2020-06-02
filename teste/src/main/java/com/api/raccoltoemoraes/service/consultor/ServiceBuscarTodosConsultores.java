package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodosConsultores {
    @Autowired
    private RepositoryConsultor repositoryConsultor;

    public List<Consultor> buscaTodosConsultores() {
        return repositoryConsultor.findAll();
    }
}
