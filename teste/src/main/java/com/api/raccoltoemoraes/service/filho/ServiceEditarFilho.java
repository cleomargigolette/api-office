package com.api.raccoltoemoraes.service.filho;

import com.api.raccoltoemoraes.domain.Filho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarFilho {

    @Autowired
    private ServiceBuscarFilhoPeloId buscarFilhoPeloId;

    @Autowired
    private ServiceSalvarFilho salvarFilho;

    public Filho editarFilho(Filho filhoAlterado) {

        Filho filhoAtual = buscarFilhoPeloId.buscarFilhoPeloId(filhoAlterado.getId());

        filhoAtual.setDataEmissaoCertidaoNascimento(filhoAlterado.getDataEmissaoCertidaoNascimento());
        filhoAtual.setMatriculaCertidaoNascimento(filhoAlterado.getMatriculaCertidaoNascimento());
        filhoAtual.setMatriculoaCdertidaoNascimentoContinuacao(filhoAlterado.getMatriculoaCdertidaoNascimentoContinuacao());
        filhoAtual.setDataNascimento(filhoAlterado.getDataNascimento());
        filhoAtual.setNome(filhoAlterado.getNome());
        filhoAtual.setSobrenome(filhoAlterado.getSobrenome());

        return salvarFilho.salvarFilho(filhoAtual);
    }
}
