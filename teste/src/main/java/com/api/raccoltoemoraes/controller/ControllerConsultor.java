package com.api.raccoltoemoraes.controller;

import com.api.raccoltoemoraes.config.security.UserPrincipal;
import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Mae;
import com.api.raccoltoemoraes.service.consultor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("public/consultor")
public class ControllerConsultor {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ServiceBuscarConsultorPeloID buscarConsultorPeloID;

    @Autowired
    private ServiceSalvarConsultor salvarConsultor;

    @Autowired
    private ServiceAlterarSenhaConsultor serviceAlterarSenhaConsultor;

    @Autowired
    private ServiceBuscarTodosConsultores buscarTodosConsultores;

    @Autowired
    private ServiceDeletarConsultor deletarConsultor;

    @Autowired
    private ServiceBuscarTodosConsultoresAtivos buscarTodosConsultoresAtivos;

    @Autowired
    private ServiceBuscarMaesConsultor buscarMaesConsultor;

    @Autowired
    private ServiceBuscaConsultorIdAtivo buscaConsultorIdAtivo;

    @PostMapping
    public ResponseEntity<Consultor> salvarConsultor(@Valid @RequestBody Consultor consultor) {
        return ResponseEntity.status(201).body(salvarConsultor.salvar(consultor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultor> buscarConsultorPeloId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(buscarConsultorPeloID.buscaPeloId(id));
    }

    @GetMapping("/ativo/{id}")
    public ResponseEntity<Consultor> buscarConsultorPeloIdAtivo(@PathVariable Long id) {
        return ResponseEntity.status(200).body(buscaConsultorIdAtivo.buscarConsultorAtivo(id));
    }

    @GetMapping("/userPrincipal")
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<Consultor> buscarUserPrincipal(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        Long id = userPrincipal.getId();
        return ResponseEntity.status(200).body(buscarConsultorPeloID.buscaPeloId(id));
    }

    @GetMapping
    public ResponseEntity<List<Consultor>> buscarTodosConsultores() {
        return ResponseEntity.status(200).body(buscarTodosConsultores.buscaTodosConsultores());
    }

    @GetMapping("/ativo")
    public ResponseEntity<List<Consultor>> buscarTodosConsultoresAtivos() {
        return ResponseEntity.status(200).body(buscarTodosConsultoresAtivos.buscarTodosAtivos());
    }

    @GetMapping("/maes")
    @RolesAllowed("ROLE_CONSULTOR")
    public ResponseEntity<List<Mae>> buscarTodasMaesConsultor(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.status(200).body(buscarMaesConsultor.buscarMaesAtivasConsultor(userPrincipal.getId()));
    }

    @PutMapping
    public ResponseEntity<Consultor> editaConsultor(@RequestBody Consultor consultor) {

        return ResponseEntity.status(200).body(serviceAlterarSenhaConsultor.alterarSenhaConsultor(consultor));
    }

    @DeleteMapping("/{id}")
    public void deletarConsultor(@PathVariable Long id) {

        deletarConsultor.deletarConsultor(id);
    }
}
