package com.api.raccoltoemoraes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Mae {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @NotNull
    private String primeiroNome;
    @NotNull
    private String sobreNome;
    @NotNull
    private Long cpf;
    private Long rg;
    private Long telefone;
    private String email;
    private String nomeMae;
    private String nomePai;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;
    private Boolean ativo;
    private Long idConsultor;
    @ManyToOne
    private Consultor consultor;
    @OneToMany(mappedBy = "mae")
    private List<Filho> filho;
    @ManyToOne
    private Endereco endereco;
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Processo processo;
}
