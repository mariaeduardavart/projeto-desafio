package br.com.banco.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/conta")
public class ContaController {
    
    @Autowired
    private ContaService contaService;

    @GetMapping("/")
    public List<Conta> buscarTodas() {
        return contaService.listarContas();
    }

    @PostMapping("/")
    public Conta inserir(@RequestBody Conta conta) {
        return contaService.incluirConta(conta);
    }

    @PutMapping("/")
    public Conta alterar(@RequestBody Conta conta) {
        return contaService.alterarConta(conta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        contaService.excluirConta(id);
        return ResponseEntity.ok().build();
    }

}
