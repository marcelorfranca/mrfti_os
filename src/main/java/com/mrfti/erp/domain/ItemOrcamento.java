package com.mrfti.erp.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrcamentoPK id = new ItemOrcamentoPK();
	
	private Double desconto;
	private Double preco;
	private Integer quantidade;
	private Integer numOrcamento;
	
	public ItemOrcamento() {
	}

	public ItemOrcamento(Orcamento orcamento, Produto produto, Double desconto, Double preco, Integer quantidade,
			Integer numOrcamento) {
		super();
		id.setOrcamento(orcamento);
		id.setProduto(produto);
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.numOrcamento = numOrcamento;
	}

	
	public double getSubTotal() {
		return (preco - desconto) * quantidade;
	}
	
	@JsonIgnore
	public Orcamento getOrcamento() {
		return id.getOrcamento();
	}
	
	
	public void setOrcamento(Orcamento orcamento) {
		id.setOrcamento(orcamento);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ItemOrcamentoPK getId() {
		return id;
	}

	public void setId(ItemOrcamentoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getNumOrcamento() {
		return numOrcamento;
	}

	public void setNumOrcamento(Integer numOrcamento) {
		this.numOrcamento = numOrcamento;
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
		ItemOrcamento other = (ItemOrcamento) obj;
		return Objects.equals(id, other.id);
	}

	/*
	 * @Override public String toString() { return "ItemOrcamento [desconto=" +
	 * desconto + ", preco=" + preco + ", quantidade=" + quantidade +
	 * ", numOrcamento=" + numOrcamento + ", getSubTotal()=" + getSubTotal() +
	 * ", getProduto()=" + getProduto().getDescricao() + "]"; }
	 */

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getDescricao());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getPreco()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
	
	
}
