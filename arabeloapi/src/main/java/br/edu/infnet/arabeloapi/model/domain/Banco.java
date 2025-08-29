package br.edu.infnet.arabeloapi.model.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Banco extends Pessoa implements EntidadeComId<Integer> {
    private Integer codigoBacen;

    @Override
    public String toString() {
        return String.format("Banco:{id:%d,nome:%s,codigoBacen:}", getId(), getNome(), getCodigoBacen());
    }
}
