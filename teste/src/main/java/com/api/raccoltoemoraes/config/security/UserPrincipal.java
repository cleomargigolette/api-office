package com.api.raccoltoemoraes.config.security;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.domain.Permissao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
public class UserPrincipal implements UserDetails {

    private Long id;

    private String nome;

    private String email;

    @JsonIgnore
    private String password;

    private Boolean ativo;

    private Permissao permissao;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id,
                         String nome,
                         String email,
                         String password,
                         Boolean ativo,
                         Permissao permissao,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.ativo = ativo;
        this.permissao = permissao;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Consultor consultor) {

        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority(consultor.getPerfil().getRole())
        );

        return new UserPrincipal(
                consultor.getId(),
                consultor.getPrimeiroNome(),
                consultor.getEmail(),
                consultor.getPassword(),
                consultor.getAtivo(),
                consultor.getPermissao(),
                authorities
        );
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return ativo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return ativo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

}