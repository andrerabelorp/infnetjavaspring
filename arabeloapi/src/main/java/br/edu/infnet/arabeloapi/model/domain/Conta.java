package br.edu.infnet.arabeloapi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta implements EntidadeComId<Integer> {
    private Integer id;
    private Banco banco;
    private TipoConta tipoConta;
    private Long numero;
    private String digitoVerificador;
    private double saldoAtual;
    private boolean ativo;

    public Conta() {
        super();
    }

    public Conta(Banco banco, TipoConta tipoConta, Long numero, String digitoVerificador) {
        this.banco = banco;
        this.tipoConta = tipoConta;
        this.numero = numero;
        this.digitoVerificador = digitoVerificador;
        ativo = true;
    }

    @Override
    public String toString() {
        return String.format("Conta ID %d, instituição [%s], saldo %f.", getId(), banco, getSaldoAtual());
    }

}
