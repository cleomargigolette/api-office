package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarConsultor {

    @Autowired
    private RepositoryConsultor repositoryConsultor;

    @Autowired
    private PasswordEncoder encoder;

    public Consultor salvar(Consultor consultor) {

        if (consultor.getId() == null) {
            consultor.setPassword(encoder.encode(consultor.getPassword()));
            consultor.setAtivo(true);
        }

        return repositoryConsultor.save(consultor);
    }
}
