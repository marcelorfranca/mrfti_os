package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mrfti.erp.domain.Servico;

public class ServicoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected String descricao;
	protected BigDecimal preco;
	
	
	public ServicoDTO() {
	}


	public ServicoDTO(Servico obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
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


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
}
