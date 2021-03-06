//package com.mrfti.erp.domain;
package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	protected Double preco;
	
	@JsonIgnore
	public List<Orcamento> getOrcamentos() {
		List<Orcamento> lista = new ArrayList<>();
		for (ItemOrcamento x : itens) {
			lista.add(x.getOrcamento());
		}
		return lista;
	}
	
	
	@ManyToOne
	@JoinColumn(name="categoriaProduto_id")
	protected CategoriaProduto categoriaProduto;
	
	
	@ManyToOne
	@JoinColumn(name="unidadeMedida_id")
	protected UnidadeMedida unidadeMedida;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemOrcamento> itens = new HashSet<>();
	
	public Produto() {
	}

	public Produto(Integer id, String descricao, Double preco, CategoriaProduto categoriaProduto,
			UnidadeMedida unidadeMedida) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.categoriaProduto = categoriaProduto;
		this.unidadeMedida = unidadeMedida;
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

	@JsonIgnore // teste para ocultar o preço no postmam
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Set<ItemOrcamento> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrcamento> itens) {
		this.itens = itens;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
}
