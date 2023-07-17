package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    
}
