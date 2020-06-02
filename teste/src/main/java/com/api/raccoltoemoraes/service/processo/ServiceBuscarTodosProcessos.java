package com.api.raccoltoemoraes.service.processo;

import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.repository.RepositoryProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodosProcessos {

    @Autowired
    private RepositoryProcesso repositoryProcesso;

    public List<Processo> buscarTodosProcessos() {
        return repositoryProcesso.findAll();
    }
}
