package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {

     @Autowired
    private TransferenciaService transferenciaService;

    
    @GetMapping("/")
    public List<Transferencia> buscarTodas() {
        return transferenciaService.obterTodasTransferencias();
    }

    @GetMapping("/por-periodo")
    public List<Transferencia> buscarPorPeriodo(
            @RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime dataInicial,
            @RequestParam("dataFinal")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime dataFinal
    ) {
        return transferenciaService.obterTransferenciasPorPeriodoTempo(dataInicial, dataFinal);
    }

    @GetMapping("/por-operador")
    public List<Transferencia> buscarPorOperador(
            @RequestParam("nomeOperadorTransacao") String nomeOperadorTransacao
    ) {
        return transferenciaService.obterTransferenciasPorNomeOperador(nomeOperadorTransacao);
    }

    @PostMapping("/")
    public Transferencia inserir(@RequestBody Transferencia transferencia) {
        return transferenciaService.incluirTransferencia(transferencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        transferenciaService.excluirTransferencia(id);
        return ResponseEntity.ok().build();
    }
    
}
