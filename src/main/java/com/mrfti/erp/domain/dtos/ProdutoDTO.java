package com.mrfti.erp.domain.dtos;

import java.io.Serializable;

import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.domain.UnidadeMedida;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected String descricao;
	protected Double preco;
	
	protected CategoriaProduto categoriaProduto;
	
	protected UnidadeMedida unidadeMedida;
	
	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
		this.categoriaProduto = obj.getCategoriaProduto();
		this.unidadeMedida = obj.getUnidadeMedida();
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

	
	
	
	
	
}
