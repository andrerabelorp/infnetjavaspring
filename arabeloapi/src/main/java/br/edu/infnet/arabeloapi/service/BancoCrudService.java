package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import org.springframework.stereotype.Service;

@Service
public class BancoCrudService extends BaseCrudService<Banco, Integer> implements CrudService<Banco, Integer> {

    @Override
    public Banco salvar(Banco entity) {
        dados.put(entity.getIdBacen(), entity);
        return entity;
    }

    @Override
    public void excluir(Integer integer) {

    }
}
