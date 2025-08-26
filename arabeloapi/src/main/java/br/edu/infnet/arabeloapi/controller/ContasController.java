package br.edu.infnet.arabeloapi.controller;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.service.ContaCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    private final ContaCrudService contaCrudService;

    public ContasController(ContaCrudService contaCrudService) {
        this.contaCrudService = contaCrudService;
    }

    @PostMapping
    public void incluir(Conta conta) {
        contaCrudService.incluir(conta);
    }

    @GetMapping
    public List<Conta> getContas() {
        return contaCrudService.obter();
    }

    @GetMapping("/{id}")
    public Conta obterPorId(@PathVariable Integer id) {
        return contaCrudService.obter(id);
    }
}
