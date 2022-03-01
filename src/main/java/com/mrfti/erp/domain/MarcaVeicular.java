package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MarcaVeicular implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marcaVeicular") // uma marca para muitos modelos
	private List<ModeloVeicular> modeloVeicular = new ArrayList<>();
	
	public MarcaVeicular() {
	}

	public MarcaVeicular(Integer id, String descricao) {
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

	public List<ModeloVeicular> getModeloVeicular() {
		return modeloVeicular;
	}

	public void setModeloVeicular(List<ModeloVeicular> modeloVeicular) {
		this.modeloVeicular = modeloVeicular;
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
		MarcaVeicular other = (MarcaVeicular) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
