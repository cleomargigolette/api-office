package com.api.raccoltoemoraes.controller.login;

import lombok.Data;

@Data
public class ResponseLogin {
    private final String accessToken;
    private String text = "você esta logado";
}
