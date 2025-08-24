package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.exceptions.EntidadeInvalidaException;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ContaCrudService extends BaseCrudService<Conta, Integer> implements CrudService<Conta, Integer> {

    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Integer obterIdNovaEntidade(Conta entity) {
        return nextId.getAndIncrement();
    }

    @Override
    public void excluir(Integer integer) {

    }

    @Override
    public void validarEntidade(Conta entidade) {
        if (entidade.getBanco() == null) {
            throw new EntidadeInvalidaException("É obrigatório informar o [Banco] para salvar [Conta].");
        }
        if (entidade.getNumero() == null) {
            throw new EntidadeInvalidaException("É obrigatório informar o [Número] para salvar [Conta].");
        }
        if (entidade.getTipoConta() == null) {
            throw new EntidadeInvalidaException("É obrigatório informar o [Tipo] para salvar [Conta].");
        }
    }

    @Override
    public String getEntityTypeName() {
        return "Conta";
    }

}
