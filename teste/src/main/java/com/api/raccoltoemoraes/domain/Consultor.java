package com.api.raccoltoemoraes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Consultor {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @NotNull
    private String primeiroNome;
    @NotNull
    private String sobreNome;
    private String password;
    @NotNull
    private String email;
    private Boolean ativo;
    private Permissao permissao;
    @JsonBackReference
    @OneToMany(mappedBy = "consultor")
    private List<Mae> maes;
    public Perfil getPerfil() {
        return Perfil.CONSULTOR;
    }
}
