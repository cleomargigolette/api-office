package com.api.raccoltoemoraes.service.mae;

import com.api.raccoltoemoraes.domain.Mae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarMae {
    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    @Autowired
    private ServiceSalvarMae salvarMae;

    public Mae editarMae(Mae maeAlterada) {
        Mae maeAtual = buscarMaePeloId.buscarMaePeloId(maeAlterada.getId());

        maeAtual.setPrimeiroNome(maeAlterada.getPrimeiroNome());
        maeAtual.setSobreNome(maeAlterada.getSobreNome());
        maeAtual.setEmail(maeAlterada.getEmail());
        maeAtual.setCpf(maeAlterada.getCpf());
        maeAtual.setDataNascimento(maeAlterada.getDataNascimento());
        maeAtual.setNomeMae(maeAlterada.getNomeMae());
        maeAtual.setNomePai(maeAlterada.getNomePai());
        maeAtual.setRg(maeAlterada.getRg());
        maeAtual.setTelefone(maeAlterada.getTelefone());

        return salvarMae.salvarMae(maeAtual);
    }
}
