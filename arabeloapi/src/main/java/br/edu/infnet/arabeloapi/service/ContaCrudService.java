package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.exceptions.CampoObrigatorioNaoPreenchidoException;
import br.edu.infnet.arabeloapi.model.domain.exceptions.OperacaoNaoPermitidaException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        if (entidade == null) {
            throw new IllegalArgumentException("Impossível validar entidade \"null\".");
        }
//        if (entidade.getBanco() == null) {
//            throw new CampoObrigatorioNaoPreenchidoException("Banco", "Conta");
//        }
        if (entidade.getNumero() == null) {
            throw new CampoObrigatorioNaoPreenchidoException("Número", "Conta");
        }
        if (entidade.getTipoConta() == null) {
            throw new CampoObrigatorioNaoPreenchidoException("Tipo", "Conta");
        }
    }

    @Override
    public String getEntityTypeName() {
        return "Conta";
    }

    @Override
    public void validarIdEstaVazio(Integer id) {
        if (!ObjectUtils.isEmpty(id)) {
            throw new OperacaoNaoPermitidaException();
        }
    }

}
