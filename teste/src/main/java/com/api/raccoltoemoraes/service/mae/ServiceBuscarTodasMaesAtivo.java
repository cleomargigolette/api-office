package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodasMaesAtivo {
    @Autowired
    private RepositoryMae repositoryMae;

    public List<Mae> buscaTodasMaesAtivo() {
        return repositoryMae.buscarTodasMaesAtivas();
    }
}
