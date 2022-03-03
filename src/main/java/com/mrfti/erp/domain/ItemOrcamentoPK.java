package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemOrcamentoPK implements Serializable { // classe chave comporta da classe orcamento e produto 
	private static final long serialVersionUID = 1L;

	
	
	@ManyToOne
	@JoinColumn(name="orcamento_id")
	private Orcamento orcamento;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	// nesta classe não usamos construtores
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orcamento, produto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrcamentoPK other = (ItemOrcamentoPK) obj;
		return Objects.equals(orcamento, other.orcamento) && Objects.equals(produto, other.produto);
	}
	
	
	
}
