package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeletarConsultor {
    @Autowired
    private RepositoryConsultor repositoryConsultor;

    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;

    public void deletarConsultor(Long id) {

        Consultor consultor = buscarConsultorPeloID.buscaPeloId(id);

        consultor.setAtivo(false);

        repositoryConsultor.save(consultor);
    }
}
