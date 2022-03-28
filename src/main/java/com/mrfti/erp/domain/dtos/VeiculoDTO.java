package com.mrfti.erp.domain.dtos;

import java.io.Serializable;

import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.ModeloVeicular;
import com.mrfti.erp.domain.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	private String placa;
	private String cor; // possivel entidade ou enum
	private Integer ano;
	private String renavam;
	private String chassi;
	private Integer kmInicial;
	private Character ativo; //S ou N
	private String observacao;
	
	private ModeloVeicular modeloVeicular;
	
	private Funcionario funcionario;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Veiculo obj) {
		this.id = obj.getId();
		this.placa = obj.getPlaca();
		this.cor = obj.getCor();
		this.ano = obj.getAno();
		this.renavam = obj.getRenavam();
		this.chassi = obj.getChassi();
		this.kmInicial = obj.getKmInicial();
		this.ativo = obj.getAtivo();
		this.observacao = obj.getObservacao();
		this.modeloVeicular = obj.getModeloVeicular();
		this.funcionario = obj.getFuncionario();
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

	
	
	
}
