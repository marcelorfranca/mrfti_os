package com.mrfti.erp.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	
	@Column(unique = true)
	private Integer numOrcamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataOrcamento = LocalDate.now();
	
	private Character aprovado = 'N'; // S ou N
	private Integer desconto;
	private String observacao;
	private String contato;
	private String observacaoRecibo;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id") // relacionando as classes
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
}
