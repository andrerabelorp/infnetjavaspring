package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import br.edu.infnet.arabeloapi.model.domain.exceptions.CampoObrigatorioNaoPreenchidoException;
import br.edu.infnet.arabeloapi.model.domain.exceptions.EntidadeNaoPodeSerExcluidaException;
import br.edu.infnet.arabeloapi.repository.BancoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.awt.dnd.InvalidDnDOperationException;

@Service
public class BancoCrudService extends BaseCrudService<Banco, Integer> implements CrudService<Banco, Integer> {

    public BancoCrudService(BancoRepository bancoRepository) {
        this.repository = bancoRepository;
    }

    @Override
    public void validarEntidade(Banco entidade) {
        if (entidade == null) {
            throw new IllegalArgumentException("Impossível validar entidade \"null\".");
        }
        if (entidade.getCodigoBacen() == null || entidade.getCodigoBacen() <= 0) {
            throw new CampoObrigatorioNaoPreenchidoException("Código BACEN", "Banco");
        }
        if (entidade.getNome() == null) {
            throw new CampoObrigatorioNaoPreenchidoException("Nome", "Conta");
        }
    }

    @Override
    public String getEntityTypeName() {
        return "Banco";
    }

    @Override
    public void validarIdEstaVazio(Integer ID) {
        if (ObjectUtils.isEmpty(ID)) {
            throw new InvalidDnDOperationException(String.format("Não é possível incluir entidade [%s] que já possui ID.", getEntityTypeName()));
        }
    }

    @Override
    public void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(String.format("ID inválido para [Banco]: [%s].", id));
        }
    }

    @Override
    public void validarExclusao(Banco entidade) {
        throw new EntidadeNaoPodeSerExcluidaException("Banco");
    }
}
