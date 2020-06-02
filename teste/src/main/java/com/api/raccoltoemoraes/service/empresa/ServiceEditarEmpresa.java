package com.api.raccoltoemoraes.service.empresa;

import com.api.raccoltoemoraes.domain.Empresa;
import com.api.raccoltoemoraes.exception.ExceptionDataInvalida;
import com.api.raccoltoemoraes.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarEmpresa {
    @Autowired
    private RepositoryEmpresa repositoryEmpresa;

    @Autowired
    private ServiceBuscarEmpresaPeloId buscarEmpresaPeloId;

    public Empresa editarEmpresa(Empresa empresaAlterada) {

        if (empresaAlterada.getDataAdmissao().isAfter(empresaAlterada.getDataDemissao())) {
            throw new ExceptionDataInvalida("Data de admissão não pode ser depois da data de demissao.");
        }

        Empresa empresaAtualizada = buscarEmpresaPeloId.buscarEmpresaPeloId(empresaAlterada.getId());

        empresaAtualizada.setSeguroDesemprego(empresaAlterada.getSeguroDesemprego());
        empresaAtualizada.setMotivoSaidaEmpresa(empresaAlterada.getMotivoSaidaEmpresa());
        empresaAtualizada.setDataDemissao(empresaAlterada.getDataDemissao());
        empresaAtualizada.setDataAdmissao(empresaAlterada.getDataAdmissao());
        empresaAtualizada.setNome(empresaAlterada.getNome());

        return repositoryEmpresa.save(empresaAtualizada);
    }
}
