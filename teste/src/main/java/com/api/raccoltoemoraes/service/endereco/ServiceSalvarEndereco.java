package com.api.raccoltoemoraes.service.endereco;

import com.api.raccoltoemoraes.domain.Endereco;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.repository.RepositoryEndereco;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import com.api.raccoltoemoraes.service.mae.ServiceBuscarMaePeloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarEndereco {
    @Autowired
    private RepositoryEndereco repositoryEndereco;

    @Autowired
    private RepositoryMae repositoryMae;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    public Endereco salvarEndereco(Endereco endereco) {
        Endereco endereco1 = repositoryEndereco.save(endereco);

        Mae mae = buscarMaePeloId.buscarMaePeloId(endereco.getIdMae());

        mae.setEndereco(endereco1);

        repositoryMae.save(mae);

        return endereco1;
    }
}
