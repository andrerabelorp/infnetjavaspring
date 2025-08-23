package br.edu.infnet.arabeloapi.controller;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.service.ContaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    private final ContaService contaService;

    public ContasController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> getContas() {
        return contaService.obter();
    }
}
