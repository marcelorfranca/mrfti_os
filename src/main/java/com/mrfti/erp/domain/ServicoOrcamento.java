package com.mrfti.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
	
	private Integer desconto;
	private BigDecimal preco;
	private Integer quantidade;
	private Integer numOrcamento;
	
	
	public ServicoOrcamento() {
	}

	public ServicoOrcamento(Orcamento orcamento, Servico servico, Integer desconto, BigDecimal preco, Integer quantidade,
			Integer numOrcamento) {
		super();
		id.setOrcamento(orcamento);
		id.setServico(servico);;
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.numOrcamento = numOrcamento;
	}

	@JsonIgnore
	public Orcamento getOrcamento() {
		return id.getOrcamento();
	}
	
	
	public String getServico() {
		return id.getServico().getDescricao(); // alterei para String e getDescricao evitando loop de serialização.
	}
	
	
	public ServicoOrcamentoPK getId() {
		return id;
	}

	public void setId(ServicoOrcamentoPK id) {
		this.id = id;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
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

	
	
	
}
