package br.edu.infnet.arabeloapi.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
}
