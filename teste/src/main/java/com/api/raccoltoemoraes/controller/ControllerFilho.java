package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.domain.Filho;
import com.api.raccoltoemoraes.service.filho.ServiceBuscarFilhoPeloId;
import com.api.raccoltoemoraes.service.filho.ServiceBuscarTodosFilhos;
import com.api.raccoltoemoraes.service.filho.ServiceEditarFilho;
import com.api.raccoltoemoraes.service.filho.ServiceSalvarFilho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/public/filho")
public class ControllerFilho {

    @Autowired
    private ServiceSalvarFilho salvarFilho;

    @Autowired
    private ServiceBuscarTodosFilhos buscarTodosFilhos;

    @Autowired
    private ServiceEditarFilho serviceEditarFilho;

    @Autowired
    private ServiceBuscarFilhoPeloId buscarFilhoPeloId;


    @PostMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Filho> salvarFilho(@RequestBody Filho filho) {
        return ResponseEntity.status(201).body(salvarFilho.salvarFilho(filho));
    }

    @GetMapping
    public ResponseEntity<List<Filho>> buscarTodosFilhos() {
        return ResponseEntity.status(200).body(buscarTodosFilhos.buscaTodosFilhos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filho> buscarFilhoPeloId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(buscarFilhoPeloId.buscarFilhoPeloId(id));
    }

    @PutMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Filho> editarFilho(@RequestBody Filho filho) {
        return ResponseEntity.status(200).body(serviceEditarFilho.editarFilho(filho));
    }

}
