package br.edu.infnet.arabeloapi.service;

import java.util.List;

public interface CrudService<T,ID> {
    T salvar(T entity);
    T obter(ID id);
    void excluir(ID id);
    List<T> obter();
}
