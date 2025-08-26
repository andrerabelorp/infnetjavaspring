package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.EntidadeComId;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCrudService<T extends EntidadeComId<ID>, ID> implements CrudService<T, ID> {

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

    public T incluir(T entidade) {
        validarIdEstaVazio(entidade.getId());
        validarEntidade(entidade);
        dados.put(obterIdNovaEntidade(entidade), entidade);
        return entidade;
    }
}
