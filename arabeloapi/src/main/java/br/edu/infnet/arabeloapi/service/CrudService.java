package br.edu.infnet.arabeloapi.service;

import java.util.List;

public interface CrudService<T extends Object,ID> {
    ID obterIdNovaEntidade(T entity);
    T salvar(T entidade);
    T obter(ID id);
    void excluir(ID id);
    List<T> obter();
    void validarEntidade(T entidade);
    String getEntityTypeName();
}
