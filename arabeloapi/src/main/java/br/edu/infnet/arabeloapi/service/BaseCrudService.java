package br.edu.infnet.arabeloapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCrudService<T extends Object, ID> implements CrudService<T, ID> {

    protected final Map<ID, T> dados = new ConcurrentHashMap<>();

    public List<T> obter() {
        return new ArrayList<>(dados.values());
    }

    public T obter(ID id) {
        T entidade = dados.get(id);

        if (entidade == null) {
            throw new IllegalArgumentException(String.format("Entidade [%s] não encontrada pelo ID.", getEntityTypeName()));
        }

        return entidade;
    }

    public T salvar(T entidade) {
        dados.put(obterIdNovaEntidade(entidade), entidade);
        return entidade;
    }
}
