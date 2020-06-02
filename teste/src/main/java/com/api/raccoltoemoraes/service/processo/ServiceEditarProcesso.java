package com.api.raccoltoemoraes.service.processo;

import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.repository.RepositoryProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarProcesso {

    @Autowired
    private ServiceBuscarProcessoPeloId buscarProcessoPeloId;

    @Autowired
    private RepositoryProcesso salvarProcesso;

    public Processo editarProcesso(Processo processoAlterado) {

        Processo processoAtual = buscarProcessoPeloId.buscarProcessoPeploId(processoAlterado.getId());

        processoAtual.setSituacaoProcesso(processoAlterado.getSituacaoProcesso());

        if (processoAlterado.getExigencia() == null && processoAlterado.getObservacao() == null) {
            return salvarProcesso.save(processoAtual);
        } else{
            processoAtual.setExigencia(processoAlterado.getExigencia());
            processoAtual.setObservacao(processoAlterado.getObservacao());
            return salvarProcesso.save(processoAtual);
        }
    }
}
