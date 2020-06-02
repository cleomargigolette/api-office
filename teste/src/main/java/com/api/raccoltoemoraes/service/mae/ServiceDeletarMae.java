package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeletarMae {
    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    @Autowired
    private RepositoryMae salvarMae;

    public void deletarMae(Long id) {

        Mae mae = buscarMaePeloId.buscarMaePeloId(id);

        mae.setAtivo(false);

        salvarMae.save(mae);
    }
}
