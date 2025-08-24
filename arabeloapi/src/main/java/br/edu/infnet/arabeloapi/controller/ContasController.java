package br.edu.infnet.arabeloapi.controller;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.service.ContaCrudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    private final ContaCrudService contaCrudService;

    public ContasController(ContaCrudService contaCrudService) {
        this.contaCrudService = contaCrudService;
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
