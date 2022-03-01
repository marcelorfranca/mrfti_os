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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ModeloVeicular implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "marcaVeicular_id") 
	private MarcaVeicular marcaVeicular; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "modeloVeicular") // um ModeloVeicular para muitos veiculos
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public ModeloVeicular() {
	}

	public ModeloVeicular(Integer id, String descricao, MarcaVeicular marcaVeicular) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.marcaVeicular = marcaVeicular;
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

	public MarcaVeicular getMarcaVeicular() {
		return marcaVeicular;
	}

	public void setMarcaVeicular(MarcaVeicular marcaVeicular) {
		this.marcaVeicular = marcaVeicular;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
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
		ModeloVeicular other = (ModeloVeicular) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
