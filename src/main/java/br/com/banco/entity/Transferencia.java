package br.com.banco.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Data;

@Entity
@Table(name = "transferencia")
@Data
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "data_transferencia", nullable = false)
    private LocalDateTime dataTransferencia;
    
    @Column(nullable = false)
    private BigDecimal valor;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;
    
    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;
    
}
