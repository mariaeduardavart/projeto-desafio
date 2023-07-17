package br.com.banco.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
      List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
      List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
}
