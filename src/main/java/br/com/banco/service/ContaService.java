package br.com.banco.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Conta incluirConta(Conta conta) {
        return contaRepository.saveAndFlush(conta);
    }

    public Conta alterarConta(Conta conta) {
        return contaRepository.saveAndFlush(conta);
    }

    public void excluirConta(Long id) {
        contaRepository.deleteById(id);
    }

    
}







