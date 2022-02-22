package com.mrfti.erp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.enums.Perfil;
import com.mrfti.erp.domain.enums.TipoPessoa;

@Entity
public abstract class Pessoa implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	protected String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataInclusao = LocalDate.now();
	
	@ElementCollection(fetch = FetchType.EAGER) // qdo der get no banco a lista de perfis devera vir com o usuario
	@CollectionTable(name = "PERFIS")// Vai criar uma tabela no bd com os perfis
	protected Set<Integer> perfis  = new HashSet<>(); // Set impede dois valores iguais 
	
	public Pessoa() {
		super();
		addPerfil(Perfil.USER_OS);
	}

	public Pessoa(Integer id, String cpfOuCnpj, String nome, String email, TipoPessoa tipoPessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		addPerfil(Perfil.USER_OS);
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

	
	public Set<Perfil> getPerfis() { // tipo Perfil altado para Integer. Chamado o metodo la de Perfil
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) { // alterado para add e lista
		this.perfis.add(perfil.getCodigo());
	}
	
	
	
	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
