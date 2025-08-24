package br.edu.infnet.arabeloapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCrudService<T, ID> {

    protected final Map<ID, T> dados = new ConcurrentHashMap<>();

    public List<T> obter() {
        return new ArrayList<>(dados.values());
    }

    public T obter(ID id) {
        return dados.get(id);
    }

}
