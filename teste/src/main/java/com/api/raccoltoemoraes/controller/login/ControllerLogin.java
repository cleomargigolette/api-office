package com.api.raccoltoemoraes.controller.login;

import com.api.raccoltoemoraes.config.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/login")
public class ControllerLogin {

    @Autowired
    private AuthenticationService service;

    @PostMapping
    public ResponseEntity<ResponseLogin> login(@RequestBody @Valid RequestLogin request) {

        String username = request.getEmail();
        String password = request.getPassword();

        String token = service.authenticate(username, password);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseLogin(token));
    }
}
