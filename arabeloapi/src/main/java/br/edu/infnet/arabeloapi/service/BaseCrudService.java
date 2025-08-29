package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.EntidadeComId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCrudService<T extends EntidadeComId<ID>, ID> implements CrudService<T, ID> {

    protected JpaRepository<T, ID> repository;
    protected final Map<ID, T> dados = new ConcurrentHashMap<>();

    public List<T> obter() {
        return repository.findAll();
    }

    public T obter(ID id) {
        validarId(id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Entidade [%s] não encontrada pelo ID.", getEntityTypeName())));
    }

    public T incluir(T entidade) {
        validarEntidade(entidade);
        return repository.save(entidade);
    }

    public T alterar(ID id, T entidade) {
        validarId(id);
        obter(id);
        entidade.setId(id);
        validarEntidade(entidade);
        dados.put(entidade.getId(), entidade);
        return entidade;
    }

    public void excluir(ID id) {
        T entidade = obter(id);
        validarExclusao(entidade);
        repository.delete(entidade);
    }
}
