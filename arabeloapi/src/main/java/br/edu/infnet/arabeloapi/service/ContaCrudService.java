package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ContaCrudService extends BaseCrudService<Conta, Integer> implements CrudService<Conta, Integer> {

    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Conta salvar(Conta entity) {
        entity.setId(nextId.getAndIncrement());
        dados.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void excluir(Integer integer) {

    }
}
