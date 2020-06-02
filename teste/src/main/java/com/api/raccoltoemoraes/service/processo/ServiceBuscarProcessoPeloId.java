package com.api.raccoltoemoraes.service.processo;

import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.exception.ExceptionDadoNaoEncontrado;
import com.api.raccoltoemoraes.repository.RepositoryProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarProcessoPeloId {

    @Autowired
    private RepositoryProcesso repositoryProcesso;

    public Processo buscarProcessoPeploId(Long id) {

        if (repositoryProcesso.findById(id).isPresent()) {
            return repositoryProcesso.getOne(id);
        } else {
            throw new ExceptionDadoNaoEncontrado("Processo não registrado.");
        }
    }
}
