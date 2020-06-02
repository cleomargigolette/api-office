package com.api.raccoltoemoraes.service.empresa;

import com.api.raccoltoemoraes.domain.Empresa;
import com.api.raccoltoemoraes.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBuscarTodasEmpresas {
    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    public List<Empresa> buscarTodasEmpresas() {
        return repositoryEmpresa.findAll();
    }
}
