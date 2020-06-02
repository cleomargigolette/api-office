package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.controller.request.RequestConsultaMae;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.service.mae.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/public/mae")
public class ControllerMae {

    @Autowired
    private ServiceSalvarMae salvarMae;

    @Autowired
    private ServiceBuscarMaePeloId buscarMaePeloId;

    @Autowired
    private ServiceBuscarTodasMaes buscarTodasMaes;

    @Autowired
    private ServiceBuscarTodasMaesAtivo buscarTodasMaesAtivo;

    @Autowired
    private ServiceBuscarTodosFilhosMae buscarTodosFilhosMae;

    @Autowired
    private ServiceEditarMae editarMae;

    @Autowired
    private ServiceDeletarMae deletarMae;

    @Autowired
    private ServiceBuscarMaePeloCpfPrimeiroNome buscarMaePeloCpfPrimeiroNome;

    @PostMapping
    public ResponseEntity<Mae> salvarMae(@Valid @RequestBody Mae mae) {
        return ResponseEntity.status(201).body(salvarMae.salvarMae(mae));
    }

    @GetMapping
    public ResponseEntity<List<Mae>> buscarTodasMaes() {
        return ResponseEntity.status(200).body(buscarTodasMaes.buscarTodasMaes());
    }

    @GetMapping("/ativo")
    public ResponseEntity<List<Mae>> buscaTodasAtivo() {
        return ResponseEntity.status(200).body(buscarTodasMaesAtivo.buscaTodasMaesAtivo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mae> buscarMaePeloId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(buscarMaePeloId.buscarMaePeloId(id));
    }

    @PostMapping("/consulta")
    public ResponseEntity<Mae> buscarMaeCpf(@RequestBody RequestConsultaMae mae) {
        return ResponseEntity.status(200).body(buscarMaePeloCpfPrimeiroNome.buscarMaePeloCpfPrimeiroNome(mae));
    }

    @PutMapping
    public ResponseEntity<Mae> editarMae(@RequestBody Mae mae) {
        return ResponseEntity.status(200).body(editarMae.editarMae(mae));
    }
}
