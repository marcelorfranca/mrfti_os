package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	//Atributos da entidade Pessoa
	protected Integer id;
	protected String nome;
	
	protected String email;
	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataInclusao = LocalDate.now();
	
	//atributos da entidade Funcionario
	protected String matricula;
	protected Character ativo;
	protected Character operacional;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate admissao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate demissao;
	
	protected String cpf;
	
	private String cnh;
	
	private String fotoCnh;
	
	
	
	
	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		//super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.dataInclusao = obj.getDataInclusao();
		this.matricula = obj.getMatricula();
		this.ativo = obj.getAtivo();
		this.operacional = obj.getOperacional();
		this.admissao = obj.getAdmissao();
		this.demissao = obj.getDemissao();
		this.cpf = obj.getCpf();
		this.cnh = obj.getCnh();
		this.fotoCnh = obj.getFotoCnh();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Character getAtivo() {
		return ativo;
	}

	public void setAtivo(Character ativo) {
		this.ativo = ativo;
	}

	public Character getOperacional() {
		return operacional;
	}

	public void setOperacional(Character operacional) {
		this.operacional = operacional;
	}

	public LocalDate getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}

	public LocalDate getDemissao() {
		return demissao;
	}

	public void setDemissao(LocalDate demissao) {
		this.demissao = demissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getFotoCnh() {
		return fotoCnh;
	}

	public void setFotoCnh(String fotoCnh) {
		this.fotoCnh = fotoCnh;
	}

	
	

	
	
}
