package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscaConsultorIdAtivo {
    @Autowired
    private RepositoryConsultor repositoryConsultor;

    public Consultor buscarConsultorAtivo(Long id){

        if (repositoryConsultor.findByIdAtivo(id).isPresent()){
            return repositoryConsultor.findByIdAtivo(id).get();
        }else{
            throw new ExceptionDadoNaoEncontrado("Sua Conta foi desativada!");
        }
    }
}
