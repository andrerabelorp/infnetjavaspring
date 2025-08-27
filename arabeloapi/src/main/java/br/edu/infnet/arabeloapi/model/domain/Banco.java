package br.edu.infnet.arabeloapi.model.domain;

import lombok.Data;

@Data
public class Banco implements EntidadeComId<Integer> {
    private int idBacen;
    private String nome;

    @Override
    public Integer getId() {
        return idBacen;
    }

    @Override
    public void setId(Integer id) {
        setIdBacen(id);
    }
}
