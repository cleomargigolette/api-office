package com.api.raccoltoemoraes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private int numeroCasa;
    private String complemento;
    private Long cep;
    private Long idMae;
    @JsonBackReference
    @OneToMany(mappedBy = "endereco")
    private List<Mae> mae;
}
