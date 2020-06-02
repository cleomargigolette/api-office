package com.api.raccoltoemoraes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Processo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAberturaProcesso;
    @Enumerated
    private SituacaoProcesso situacaoProcesso;
    private String exigencia;
    private String observacao;
    @JsonBackReference
    @OneToOne
    private Mae mae;
    private Long idConsultor;
}
