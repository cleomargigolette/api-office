package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.controller.request.RequestConsultaMae;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryMae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarMaePeloCpfPrimeiroNome {
    @Autowired
    private RepositoryMae repositoryMae;

    public Mae buscarMaePeloCpfPrimeiroNome(RequestConsultaMae mae) {

        String primeiroNome = mae.getPrimeiroNome();

        Long cpf  = mae.getCpf();

        if (repositoryMae.findByCpf(cpf,primeiroNome).isPresent()) {
            return repositoryMae.findByCpf(cpf,primeiroNome).get();
        } else {
            throw new ExceptionDadoNaoEncontrado("Mãe não encontrada. Tente novamente.");
        }

    }
}
