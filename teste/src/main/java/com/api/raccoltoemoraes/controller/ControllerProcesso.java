package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.domain.Processo;
import com.api.raccoltoemoraes.service.processo.ServiceBuscarTodosProcessos;
import com.api.raccoltoemoraes.service.processo.ServiceEditarProcesso;
import com.api.raccoltoemoraes.service.processo.ServiceSalvarProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/public/processo")
public class ControllerProcesso {
    @Autowired
    private ServiceSalvarProcesso salvarProcesso;

    @Autowired
    private ServiceEditarProcesso editarProcesso;

    @Autowired
    private ServiceBuscarTodosProcessos buscarTodosProcessos;

    @PostMapping
    public ResponseEntity<Processo> salvarProcesso(@RequestBody Processo processo) {
        return ResponseEntity.status(201).body(salvarProcesso.salvarProcessso(processo));
    }

    @GetMapping
    public ResponseEntity<List<Processo>> buscarTodosProcessos() {
        return ResponseEntity.status(200).body(buscarTodosProcessos.buscarTodosProcessos());
    }

    @PutMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Processo> editarProcesso(@RequestBody Processo processo) {
        return ResponseEntity.status(200).body(editarProcesso.editarProcesso(processo));
    }
}
