package br.edu.infnet.arabeloapi.controller;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.TipoConta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    @GetMapping
    public Conta getContas() {
        Conta conta = new Conta();
        conta.setId(1);
        conta.setCodigoBanco(341);
        conta.setNumero(12345L);
        conta.setTipoConta(TipoConta.CORRENTE);
        conta.setAtivo(true);
        conta.setSaldoAtual(135.76);

        return conta;
    }
}
