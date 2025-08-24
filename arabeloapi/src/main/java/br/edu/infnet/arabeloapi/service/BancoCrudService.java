package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import br.edu.infnet.arabeloapi.model.domain.exceptions.EntidadeInvalidaException;
import org.springframework.stereotype.Service;

@Service
public class BancoCrudService extends BaseCrudService<Banco, Integer> implements CrudService<Banco, Integer> {

    @Override
    public Integer obterIdNovaEntidade(Banco entity) {
        return entity.getIdBacen();
    }

    @Override
    public Banco salvar(Banco entidade) {
        dados.put(entidade.getIdBacen(), entidade);
        return entidade;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public void validarEntidade(Banco entidade) {
        if (entidade.getIdBacen() <= 0) {
            throw new EntidadeInvalidaException("É obrigatório informar o [Código Bacen] para salvar [Banco].");
        }
        if (entidade.getNome() == null) {
            throw new EntidadeInvalidaException("É obrigatório informar o [Nome] para salvar [Banco].");
        }
    }

    @Override
    public String getEntityTypeName() {
        return "Banco";
    }
}
