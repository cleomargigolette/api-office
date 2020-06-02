package com.api.raccoltoemoraes.service.consultor;

import com.api.raccoltoemoraes.domain.Consultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceAlterarSenhaConsultor {
    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;

    @Autowired
    private ServiceSalvarConsultor salvarConsultor;

    @Autowired
    private PasswordEncoder encoder;

    public Consultor alterarSenhaConsultor(Consultor consultorAlterado) {

        Consultor consultorAtual = buscarConsultorPeloID.buscaPeloId(consultorAlterado.getId());

        consultorAtual.setPassword(encoder.encode(consultorAlterado.getPassword()));

        return salvarConsultor.salvar(consultorAtual);
    }
}
