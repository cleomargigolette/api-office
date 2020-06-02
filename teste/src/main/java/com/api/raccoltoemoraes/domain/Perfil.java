package com.api.raccoltoemoraes.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Perfil {

    CONSULTOR("ROLE_CONSULTOR");

    private final String role;
}
