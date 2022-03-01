package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String placa;
	private String cor; // possivel entidade ou enum
	private Integer ano;
	private String renavam;
	private String chassi;
	private Integer kmInicial;
	private Character ativo; //S ou N
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "modeloVeicular_id") 
	private ModeloVeicular modeloVeicular;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id") 
	private Funcionario funcionario;
	
	public Veiculo() {
	}

	public Veiculo(Integer id, String placa, String cor, Integer ano, String renavam, String chassi, Integer kmInicial,
			Character ativo, String observacao, ModeloVeicular modeloVeicular, Funcionario funcionario) {
		super();
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.renavam = renavam;
		this.chassi = chassi;
		this.kmInicial = kmInicial;
		this.ativo = ativo;
		this.observacao = observacao;
		this.modeloVeicular = modeloVeicular;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(Integer kmInicial) {
		this.kmInicial = kmInicial;
	}

	public Character getAtivo() {
		return ativo;
	}

	public void setAtivo(Character ativo) {
		this.ativo = ativo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ModeloVeicular getModeloVeicular() {
		return modeloVeicular;
	}

	public void setModeloVeicular(ModeloVeicular modeloVeicular) {
		this.modeloVeicular = modeloVeicular;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id) && Objects.equals(placa, other.placa);
	}

	
	
	
}
