package com.api.raccoltoemoraes.service.filho;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.exception.ExceptionDataInvalida;
import com.api.raccoltoemoraes.repository.RepositoryFilho;
import com.api.raccoltoemoraes.service.mae.ServiceBuscarMaePeloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceSalvarFilho {

    @Autowired
    private RepositoryFilho repositoryFilho;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    public Filho salvarFilho(Filho filho) {

        LocalDate hoje = LocalDate.now();

        if (filho.getDataNascimento().isBefore(hoje.minusYears(5))) {
            throw new ExceptionDataInvalida("Data de nascimento invalidá, precisa ser menor que 5 anos.");
        }

        if (filho.getMae() == null) {

            Mae maeAdicionada = buscarMaePeloId.buscarMaePeloId(filho.getIdMae());

            filho.setMae(maeAdicionada);
        }

        return repositoryFilho.save(filho);
    }
}
