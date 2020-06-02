package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.domain.Empresa;
import com.api.raccoltoemoraes.service.empresa.ServiceBuscarTodasEmpresas;
import com.api.raccoltoemoraes.service.empresa.ServiceEditarEmpresa;
import com.api.raccoltoemoraes.service.empresa.ServiceSalvarEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/public/empresa")
public class ControllerEmpresa {
    @Autowired
    private ServiceSalvarEmpresa salvarEmpresa;

    @Autowired
    private ServiceBuscarTodasEmpresas buscarTodasEmpresas;

    @Autowired
    private ServiceEditarEmpresa editarEmpresa;

    @PostMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Empresa> salvaEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.status(201).body(salvarEmpresa.salvarEmpresa(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> buscarTodasEmpresas() {
        return ResponseEntity.status(200).body(buscarTodasEmpresas.buscarTodasEmpresas());
    }

    @PutMapping
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Empresa> editarEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.status(200).body(editarEmpresa.editarEmpresa(empresa));
    }
}
