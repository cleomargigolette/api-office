package com.api.raccoltoemoraes.service.empresa;

import com.api.raccoltoemoraes.domain.Empresa;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.exception.ExceptionDataInvalida;
import com.api.raccoltoemoraes.repository.RepositoryEmpresa;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import com.api.raccoltoemoraes.service.mae.ServiceBuscarMaePeloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarEmpresa {
    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    @Autowired
    private RepositoryMae repositoryMae;

    public Empresa salvarEmpresa(Empresa empresa) {

        if (empresa.getDataAdmissao().isAfter(empresa.getDataDemissao())) {
            throw new ExceptionDataInvalida("Data de admissão não pode ser depois da data de demissao.");
        }

        Empresa empresaAtual = repositoryEmpresa.save(empresa);

        Mae mae = buscarMaePeloId.buscarMaePeloId(empresa.getIdMae());

        mae.setEmpresa(empresa);

        repositoryMae.save(mae);

        return empresaAtual;
    }
}
