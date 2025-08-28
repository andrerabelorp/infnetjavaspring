package br.edu.infnet.arabeloapi.model.domain;

import jakarta.persistence.Entity;

@Entity
public class Banco extends Pessoa implements EntidadeComId<Integer> {

    @Override
    public String toString() {
        return String.format("Banco:{id:%d,nome:%s}", getId(), getNome());
    }

    public Integer getCodigoBacen() {
        return getId();
    }

    @Override
    public void setId(Integer id) {

    }
}
