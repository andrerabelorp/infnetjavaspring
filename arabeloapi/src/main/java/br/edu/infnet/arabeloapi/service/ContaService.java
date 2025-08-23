package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.TipoConta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ContaService implements CrudService<Conta, Integer> {

    private final Map<Integer, Conta> dados = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Conta salvar(Conta entity) {
        entity.setId(nextId.getAndIncrement());
        dados.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Conta obter(Integer integer) {
        Conta conta = new Conta();

        conta.setId(1);
        conta.setCodigoBanco(341);
        conta.setNumero(12345L);
        conta.setTipoConta(TipoConta.CORRENTE);
        conta.setAtivo(true);
        conta.setSaldoAtual(135.76);;

        return conta;
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public List<Conta> obter() {
        return new ArrayList<>(dados.values());
    }
}
