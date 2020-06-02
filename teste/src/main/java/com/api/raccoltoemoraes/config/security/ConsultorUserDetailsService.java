package com.api.raccoltoemoraes.config.security;

import com.api.raccoltoemoraes.domain.Consultor;
import com.api.raccoltoemoraes.repository.RepositoryConsultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class ConsultorUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositoryConsultor repositoryConsultor;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Consultor consultor = getUser(() -> repositoryConsultor.findByEmail(username));
        return UserPrincipal.create(consultor);
    }

    public UserDetails loadUserById(Long id) {
        Consultor consultor = getUser(() -> repositoryConsultor.findById(id));
        return UserPrincipal.create(consultor);
    }

    private Consultor getUser(Supplier<Optional<Consultor>> supplier) {
        return supplier.get().orElseThrow(() ->
                new UsernameNotFoundException("Usuário não cadastrado")
        );
    }
}
