package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.EntidadeComId;

import java.util.List;

public interface CrudService<T extends EntidadeComId<ID>, ID> {
    ID obterIdNovaEntidade(T entity);
    T incluir(T entidade);
    T obter(ID id);
    void excluir(ID id);
    List<T> obter();
    void validarEntidade(T entidade);
    String getEntityTypeName();
    void validarIdEstaVazio(ID id);
    T alterar(ID id, T entidade);
    void validarId(ID id);
    void validarExclusao(T entidade);
}
