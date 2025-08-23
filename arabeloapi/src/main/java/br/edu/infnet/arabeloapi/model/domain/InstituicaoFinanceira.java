package br.edu.infnet.arabeloapi.model.domain;

public class InstituicaoFinanceira {
    int id;
    String nome;
    String codigoBacen;

    public InstituicaoFinanceira(String nome, String codigoBacen) {
        this.nome = nome;
        this.codigoBacen = codigoBacen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(String codigoBacen) {
        this.codigoBacen = codigoBacen;
    }
}
