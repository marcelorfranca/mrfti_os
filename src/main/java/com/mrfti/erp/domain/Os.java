package com.mrfti.erp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.enums.ResultadoOs;
import com.mrfti.erp.domain.enums.StatusOs;
import com.mrfti.erp.domain.enums.Turno;

@Entity
public class Os {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAgendamento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataSolicitacao;
	private String observacao;
	private ResultadoOs resultado;
	private Turno turnoAgendado;
	private StatusOs status;
	
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
