package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodosFilhosMae {

    @Autowired
    private RepositoryMae repositoryMae;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    public List<Filho> buscarTodosFilhoMae(Long id) {

        Mae mae = buscarMaePeloId.buscarMaePeloId(id);

        return repositoryMae.buscarTodosFilhosMae(mae);
    }
}
