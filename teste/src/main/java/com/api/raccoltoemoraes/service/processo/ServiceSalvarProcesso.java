package com.api.raccoltoemoraes.service.processo;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.domain.SituacaoProcesso;
import com.api.raccoltoemoraes.repository.RepositoryProcesso;
import com.api.raccoltoemoraes.service.consultor.ServiceBuscarConsultorPeloID;
import com.api.raccoltoemoraes.service.mae.ServiceBuscarMaePeloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceSalvarProcesso {
    @Autowired
    private RepositoryProcesso repositoryProcesso;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;

    public Processo salvarProcessso(Processo processo) {

        Consultor consultor = buscarConsultorPeloID.buscaPeloId(processo.getIdConsultor());

        LocalDate hoje = LocalDate.now();

        processo.setDataAberturaProcesso(hoje);

        processo.setSituacaoProcesso(SituacaoProcesso.ANALISE);

        return repositoryProcesso.save(processo);
    }
}
