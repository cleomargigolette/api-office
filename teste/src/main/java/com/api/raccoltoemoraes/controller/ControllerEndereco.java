package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.domain.Endereco;
import com.api.raccoltoemoraes.service.endereco.ServiceBuscarEnderecoPeloId;
import com.api.raccoltoemoraes.service.endereco.ServiceBuscarTodosEnderecos;
import com.api.raccoltoemoraes.service.endereco.ServiceEditarEndereco;
import com.api.raccoltoemoraes.service.endereco.ServiceSalvarEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/public/endereco")
public class ControllerEndereco {
    @Autowired
    private ServiceSalvarEndereco salvarEndereco;

    @Autowired
    private ServiceBuscarTodosEnderecos buscarTodosEnderecos;

    @Autowired
    private ServiceBuscarEnderecoPeloId buscarEnderecoPeloId;

    @Autowired
    private ServiceEditarEndereco editarEndereco;

    @PostMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(201).body(salvarEndereco.salvarEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscaTodosEndereco() {
        return ResponseEntity.status(200).body(buscarTodosEnderecos.buscarTodosEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPeloId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(buscarEnderecoPeloId.buscarEnderecoPeloId(id));
    }

    @PutMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Endereco> editarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(200).body(editarEndereco.editarEndereco(endereco));
    }
}
