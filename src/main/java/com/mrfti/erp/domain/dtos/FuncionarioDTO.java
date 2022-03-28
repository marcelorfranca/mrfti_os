package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cargo;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Setor;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	//Atributos da entidade Pessoa
	protected Integer id;
	protected String nome;
	
	@NotNull(message = "Campo EMAIL é requerido")
	protected String email;
	
	@NotNull(message = "Campo Telefone é requerido")
	protected String telefone1;
	protected String telefone2;
	protected String telefone3;
	
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
	
	@NotNull(message = "Campo CPF é requerido")
	@CPF
	protected String cpf;
	
	private String cnh;
	private String fotoCnh;
	private Setor setor;
	private Cargo cargo;
	
	
	
	
	
	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone1 = obj.getTelefone1();
		this.telefone2 = obj.getTelefone2();
		this.telefone3 = obj.getTelefone3();
		this.dataInclusao = obj.getDataInclusao();
		this.matricula = obj.getMatricula();
		this.ativo = obj.getAtivo();
		this.operacional = obj.getOperacional();
		this.admissao = obj.getAdmissao();
		this.demissao = obj.getDemissao();
		this.cpf = obj.getCpf();
		this.cnh = obj.getCnh();
		this.fotoCnh = obj.getFotoCnh();
		this.cargo = obj.getCargo();
		this.setor = obj.getSetor();
	
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	
}
