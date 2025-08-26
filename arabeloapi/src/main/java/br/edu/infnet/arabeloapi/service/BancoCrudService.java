package br.edu.infnet.arabeloapi.service;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import br.edu.infnet.arabeloapi.model.domain.exceptions.CampoObrigatorioNaoPreenchidoException;
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
        if (entidade == null) {
            throw new IllegalArgumentException("Impossível validar entidade \"null\".");
        }
        if (entidade.getIdBacen() <= 0) {
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
}
