package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.exceptions.CampoObrigatorioNaoPreenchidoException;
import br.edu.infnet.arabeloapi.model.domain.exceptions.EntidadeNaoPodeSerExcluidaException;
import br.edu.infnet.arabeloapi.model.domain.exceptions.OperacaoNaoPermitidaException;
import br.edu.infnet.arabeloapi.repository.ContaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ContaCrudService extends BaseCrudService<Conta, Integer> implements CrudService<Conta, Integer>, CrudAtivoService<Conta, Integer> {

    public ContaCrudService(ContaRepository contaRepository) {
        this.repository = contaRepository;
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

    @Override
    public void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(String.format("ID inválido para Conta: [%s].", id));
        }
    }

    @Override
    public void validarExclusao(Conta entidade) {
        if (!Double.valueOf(0.0).equals(entidade.getSaldoAtual())) {
            throw new EntidadeNaoPodeSerExcluidaException("Conta");
        }
    }

    @Override
    public Conta inativar(Integer id) {
        Conta conta = obter(id);
        if (!conta.isAtivo()) {
            System.out.println("Conta [" + conta + "] já está inativa!");
        } else {
            conta.setAtivo(false);
            dados.put(id, conta);
        }
        return conta;
    }
}
