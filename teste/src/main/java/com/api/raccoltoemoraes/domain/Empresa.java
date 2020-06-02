package com.api.raccoltoemoraes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private String nome;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private Boolean seguroDesemprego;
    private Long idMae;
    @Enumerated
    private MotivoSaidaEmpresa motivoSaidaEmpresa;
    @JsonBackReference
    @OneToOne
    private Mae mae;

}
