package br.edu.infnet.arabeloapi.controller;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.service.ContaCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
    public ResponseEntity<Conta> incluir(@RequestBody Conta conta) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contaCrudService.incluir(conta));
    }

    @PutMapping(value = "/{id}")
    public Conta alterar(@PathVariable Integer id, @RequestBody Conta conta) {
        return contaCrudService.alterar(id, conta);
    }

    @PatchMapping(value = "/{id}/inativar")
    public Conta inativar(@PathVariable Integer id) {
        return contaCrudService.inativar(id);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Integer id) {
        contaCrudService.excluir(id);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getContas() {
        List<Conta> contas = contaCrudService.obter();
        if (ObjectUtils.isEmpty(contas)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public Conta obterPorId(@PathVariable Integer id) {
        return contaCrudService.obter(id);
    }
}
