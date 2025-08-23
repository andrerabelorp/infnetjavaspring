package br.edu.infnet.arabeloapi.model.domain;

public class Conta {
    int id;
    InstituicaoFinanceira instituicaoFinanceira;
    TipoConta tipoConta;
    Long numero;
    String digitoVerificador;
    double saldoAtual;
    boolean ativo;

    public Conta(InstituicaoFinanceira instituicaoFinanceira, TipoConta tipoConta, Long numero, String digitoVerificador) {
        this.instituicaoFinanceira = instituicaoFinanceira;
        this.tipoConta = tipoConta;
        this.numero = numero;
        this.digitoVerificador = digitoVerificador;
        ativo = true;
    }

    @Override
    public String toString() {
        return String.format("Conta ID %d, instituição [%s], saldo %f.", getId(), instituicaoFinanceira.toString(), getSaldoAtual());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
