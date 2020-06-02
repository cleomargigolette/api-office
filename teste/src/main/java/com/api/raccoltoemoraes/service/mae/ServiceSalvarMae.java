package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.exception.ExceptionDataInvalida;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import com.api.raccoltoemoraes.service.consultor.ServiceBuscarConsultorPeloID;
import com.api.raccoltoemoraes.service.processo.ServiceSalvarProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceSalvarMae {
    @Autowired
    private RepositoryMae repositoryMae;
    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;
    @Autowired
    private ServiceSalvarProcesso serviceSalvarProcesso;

    public Mae salvarMae(Mae mae) {

        Processo processo = new Processo();

        processo.setIdConsultor(mae.getIdConsultor());

        Processo novoProcesso = serviceSalvarProcesso.salvarProcessso(processo);

        mae.setProcesso(novoProcesso);

        LocalDate hoje = LocalDate.now();

        if (mae.getDataNascimento().isAfter(hoje.minusYears(14))) {
            throw new ExceptionDataInvalida("Essa data é invalida pois a mãe nao tem idade suficiente.");
        }

        Long idUserConsultor = mae.getIdConsultor();

        Consultor consultor = buscarConsultorPeloID.buscaPeloId(idUserConsultor);

        mae.setConsultor(consultor);
        mae.setAtivo(true);

        return repositoryMae.save(mae);
    }
}