package br.edu.infnet.arabeloapi.model.domain.exceptions;

import br.edu.infnet.arabeloapi.model.domain.EntidadeComId;

public class EntidadeNaoPodeSerExcluidaException extends RuntimeException {
    public EntidadeNaoPodeSerExcluidaException(String entidade) {
        super(String.format("Entidade não pode ser excluída: [\n%s\n]", entidade));
    }
}
