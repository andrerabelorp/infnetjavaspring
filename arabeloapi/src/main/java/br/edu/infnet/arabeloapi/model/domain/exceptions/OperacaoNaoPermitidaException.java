package br.edu.infnet.arabeloapi.model.domain.exceptions;

public class OperacaoNaoPermitidaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OperacaoNaoPermitidaException() {
        super("Não é possível incluir entidade que já possui ID.");
    }
}
