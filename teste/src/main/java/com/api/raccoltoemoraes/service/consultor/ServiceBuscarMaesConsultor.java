package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarMaesConsultor {

    @Autowired
    private RepositoryConsultor repositoryConsultor;

    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;

    public List<Mae> buscarMaesAtivasConsultor(Long id) {

        Consultor consultor = buscarConsultorPeloID.buscaPeloId(id);

        return repositoryConsultor.buscarTodasMaesConsultor(consultor);
    }
}
