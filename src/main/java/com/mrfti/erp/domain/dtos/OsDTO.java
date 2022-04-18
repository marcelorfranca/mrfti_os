package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Os;
import com.mrfti.erp.domain.ServicoOs;
import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.domain.Zona;
import com.mrfti.erp.domain.enums.ResultadoOs;
import com.mrfti.erp.domain.enums.StatusOs;
import com.mrfti.erp.domain.enums.Turno;

public class OsDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	
	private Integer numOs;
	
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
	
	private Funcionario funcionario;
	
	private Cliente cliente;
	
	private Endereco enderecoOs;
	
	private Setor setor;
	
	private Zona zona;

	private Set<ServicoOs> servicos = new HashSet<>();
	
	public OsDTO() {
	}

	public OsDTO(Os obj) {
		this.id = obj.getId();
		this.numOs =obj.getNumOs();
		this.dataAbertura = obj.getDataAbertura();
		this.dataAgendamento = obj.getDataAgendamento();
		this.dataSolicitacao = obj.getDataSolicitacao();
		this.observacao = obj.getObservacao();
		this.resultado = obj.getResultado();
		this.turnoAgendado = obj.getTurnoAgendado();
		this.status = obj.getStatus();
		this.funcionario = obj.getFuncionario();
		this.cliente = obj.getCliente();
		this.enderecoOs = obj.getEnderecoOs();
		this.setor = obj.getSetor();
		this.zona = obj.getZona();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumOs() {
		return numOs;
	}

	public void setNumOs(Integer numOs) {
		this.numOs = numOs;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ResultadoOs getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoOs resultado) {
		this.resultado = resultado;
	}

	public Turno getTurnoAgendado() {
		return turnoAgendado;
	}

	public void setTurnoAgendado(Turno turnoAgendado) {
		this.turnoAgendado = turnoAgendado;
	}

	public StatusOs getStatus() {
		return status;
	}

	public void setStatus(StatusOs status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoOs() {
		return enderecoOs;
	}

	public void setEnderecoOs(Endereco enderecoOs) {
		this.enderecoOs = enderecoOs;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Set<ServicoOs> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoOs> servicos) {
		this.servicos = servicos;
	}

	
	
	
	
}
