package com.api.raccoltoemoraes.controller.request;

import lombok.Data;

@Data
public class RequestAlterarSenhaConsultor {
    private Long Id;
    private String password;
}
