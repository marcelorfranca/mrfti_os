package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Usuario;
import com.mrfti.erp.domain.enums.Perfil;


public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected String nome;
	protected String email;
	protected String senha;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataInclusao;
	
	protected Set<Integer> perfis  = new HashSet<>(); 
	
	UsuarioDTO(){
		super();
		addPerfil(Perfil.CLIENTE);
	}


	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.dataInclusao = obj.getDataInclusao();
		addPerfil(Perfil.CLIENTE);
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


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}


	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	
	
	
	
	
}
