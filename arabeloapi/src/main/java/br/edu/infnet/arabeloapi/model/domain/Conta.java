package br.edu.infnet.arabeloapi.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Conta implements EntidadeComId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_banco")
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
