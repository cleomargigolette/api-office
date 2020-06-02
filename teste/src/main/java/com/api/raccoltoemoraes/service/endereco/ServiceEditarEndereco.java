package com.api.raccoltoemoraes.service.endereco;

import com.api.raccoltoemoraes.domain.Endereco;
import com.api.raccoltoemoraes.repository.RepositoryEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarEndereco {
    @Autowired
    private ServiceBuscarEnderecoPeloId buscarEnderecoPeloId;

    @Autowired
    private RepositoryEndereco repositoryEndereco;

    public Endereco editarEndereco(Endereco enderecoAlterado) {

        Endereco enderecoAtualizado = buscarEnderecoPeloId.buscarEnderecoPeloId(enderecoAlterado.getId());

        enderecoAtualizado.setBairro(enderecoAlterado.getBairro());
        enderecoAtualizado.setCep(enderecoAlterado.getCep());
        enderecoAtualizado.setCidade(enderecoAlterado.getCidade());
        enderecoAtualizado.setComplemento(enderecoAlterado.getComplemento());
        enderecoAtualizado.setEstado(enderecoAlterado.getEstado());
        enderecoAtualizado.setNumeroCasa(enderecoAlterado.getNumeroCasa());
        enderecoAtualizado.setRua(enderecoAlterado.getRua());

        return repositoryEndereco.save(enderecoAtualizado);
    }
}
