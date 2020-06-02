package com.api.raccoltoemoraes.service.filho;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.repository.RepositoryFilho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodosFilhos {
    @Autowired
    private RepositoryFilho repositoryFilho;

    public List<Filho> buscaTodosFilhos() {
        return repositoryFilho.findAll();
    }
}
