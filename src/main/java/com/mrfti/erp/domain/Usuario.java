package com.mrfti.erp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrfti.erp.domain.enums.Perfil;

@Entity
public class Usuario extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String senha;
	
	
	@ElementCollection(fetch = FetchType.EAGER) // qdo der get no banco a lista de perfis devera vir com o usuario
	@CollectionTable(name = "PERFIS")// Vai criar uma tabela no bd com os perfis
	protected Set<Integer> perfis  = new HashSet<>(); // Set impede dois valores iguais 
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Orcamento> orcamentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario") // um usuario para muitas OSs
	private List<Os> os = new ArrayList<>();
	
	
	public Usuario() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	
	

	public Usuario(Integer id, String nome, String email, LocalDate dataInclusao, String senha, Perfil perfil) {
		super(id, nome, email, dataInclusao);
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}
	
	
	public String getSenha() {
		return senha;
	}

	

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() { // tipo Perfil altado para Integer. Chamado o metodo la de Perfil
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) { // Add e lista
		this.perfis.add(perfil.getCodigo());
	}
	
	
	
	
	
	
	
}
