package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> obterTodasTransferencias() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> obterTransferenciasPorPeriodoTempo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        List<Transferencia> transferencias = transferenciaRepository.findByDataTransferenciaBetween(dataInicial, dataFinal);
    
        if (transferencias.isEmpty()) {
            throw new NoSuchElementException("Não foram encontradas transferências no período informado.");
        }
        
        return transferencias;
    }

    public List<Transferencia> obterTransferenciasPorNomeOperador(String nomeOperadorTransacao) {
        List<Transferencia> transferencias = transferenciaRepository.findByNomeOperadorTransacao(nomeOperadorTransacao);
    
        if (transferencias.isEmpty()) {
            throw new NoSuchElementException("Não foram encontradas transferências para o operador: " + nomeOperadorTransacao);
        }
        
        return transferencias;
    }

    public Transferencia incluirTransferencia(Transferencia transferencia) {
        return transferenciaRepository.saveAndFlush(transferencia);
    }

    public void excluirTransferencia(Long id) {
        Optional<Transferencia> transferenciaOptional = transferenciaRepository.findById(id);
        if (transferenciaOptional.isPresent()) {
            Transferencia transferencia = transferenciaOptional.get();
            transferenciaRepository.delete(transferencia);
        } else {
            throw new NoSuchElementException("Transferência não encontrada com o ID: " + id);
        }

    }
}
