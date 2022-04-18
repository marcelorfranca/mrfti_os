package com.mrfti.erp.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServicoOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ServicoOrcamentoPK id = new ServicoOrcamentoPK();
	
	private Double desconto;
	private Double preco;
	private Integer quantidade;
	private Integer numOrcamento;
	
	
	public ServicoOrcamento() {
	}

	public ServicoOrcamento(Orcamento orcamento, Servico servico, Double desconto, Double preco, Integer quantidade,
			Integer numOrcamento) {
		super();
		id.setOrcamento(orcamento);
		id.setServico(servico);;
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
	
	public Integer getIdServico() {
		return id.getServico().getId(); // não havia sido implementado
	}
	
	public String getServico() {
		return id.getServico().getDescricao(); // alterei para String e getDescricao evitando loop de serialização.
	}
	
	public void setServico(Servico servico) {
		id.setServico(servico);
	}
	
	
	public ServicoOrcamentoPK getId() {
		return id;
	}

	public void setId(ServicoOrcamentoPK id) {
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
		ServicoOrcamento other = (ServicoOrcamento) obj;
		return Objects.equals(id, other.id);
	}

	/*
	 * @Override public String toString() { return "ServicoOrcamento [desconto=" +
	 * desconto + ", preco=" + preco + ", quantidade=" + quantidade +
	 * ", numOrcamento=" + numOrcamento + ", getSubTotal()=" + getSubTotal() + "]";
	 * }
	 */

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getServico());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getPreco()));
		builder.append(", Nto Orçamento: ");
		builder.append(getNumOrcamento());
		builder.append(", Desconto: ");
		builder.append(getDesconto());
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
	
	
}
