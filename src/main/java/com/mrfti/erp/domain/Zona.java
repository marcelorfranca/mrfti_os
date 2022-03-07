package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Zona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "zona") // uma zona para muitas Ordens de Serviço
	private List<Os> Oss = new ArrayList<>();
	
	
	public Zona() {
	}


	public Zona(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonIgnore
	public List<Os> getOss() {
		return Oss;
	}


	public void setOss(List<Os> oss) {
		Oss = oss;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zona other = (Zona) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
