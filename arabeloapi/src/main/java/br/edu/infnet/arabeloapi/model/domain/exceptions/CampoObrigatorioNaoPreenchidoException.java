package br.edu.infnet.arabeloapi.model.domain.exceptions;

public class CampoObrigatorioNaoPreenchidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CampoObrigatorioNaoPreenchidoException(String nomeCampo, String nomeEntidade) {

        super(String.format("É obrigatório informar o [%s] para salvar [%s].", nomeCampo, nomeEntidade));
    }
}
