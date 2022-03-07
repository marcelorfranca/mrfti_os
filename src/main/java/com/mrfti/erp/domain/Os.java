package com.mrfti.erp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrfti.erp.domain.enums.ResultadoOs;
import com.mrfti.erp.domain.enums.StatusOs;
import com.mrfti.erp.domain.enums.Turno;

@Entity
public class Os implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
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
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id") // relacionando as classes
	private Funcionario funcionario;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	@ManyToOne
	@JoinColumn(name="endereco_os_id")
	private Endereco enderecoOs;
	
	
	@ManyToOne
	@JoinColumn(name = "setor_id") // relacionando as classes
	private Setor setor;
	
	
	@ManyToOne
	@JoinColumn(name = "zona_id") 
	private Zona zona;
	
	
	@OneToMany(mappedBy="id.os")
	private Set<ServicoOs> servicos = new HashSet<>();
	
	
	public Os() {
	}

	public Os(Integer id, Integer numOs, LocalDate dataAbertura, LocalDate dataAgendamento, LocalDate dataSolicitacao,
			String observacao, ResultadoOs resultado, Turno turnoAgendado, StatusOs status, Funcionario funcionario,
			Cliente cliente, Usuario usuario, Endereco enderecoOs, Setor setor, Zona zona) {
		super();
		this.id = id;
		this.numOs = numOs;
		this.dataAbertura = dataAbertura;
		this.dataAgendamento = dataAgendamento;
		this.dataSolicitacao = dataSolicitacao;
		this.observacao = observacao;
		this.resultado = resultado;
		this.turnoAgendado = turnoAgendado;
		this.status = status;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.usuario = usuario;
		this.enderecoOs = enderecoOs;
		this.setor = setor;
		this.zona = zona;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	
	public Set<ServicoOs> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoOs> servicos) {
		this.servicos = servicos;
	}

	
	
	public Integer getNumOs() {
		return numOs;
	}


	public void setNumOs(Integer numOs) {
		this.numOs = numOs;
	}
	
	
	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Os other = (Os) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
