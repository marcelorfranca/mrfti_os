package com.mrfti.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ServicoOs implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServicoOsPK id = new ServicoOsPK();
	
	private Integer desconto;
	private BigDecimal preco;
	private Integer quantidade;
	private Integer numOs;
	
	public ServicoOs() {
	}

	public ServicoOs(Os os, Servico servico, Integer desconto, BigDecimal preco, Integer quantidade,
			Integer numOs) {
		super();
		id.setOs(os);
		id.setServico(servico);
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.numOs = numOs;
	}

	public Os getOs() {
		return id.getOs();
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	
	
	public ServicoOsPK getId() {
		return id;
	}

	public void setId(ServicoOsPK id) {
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

	public Integer getNumOs() {
		return numOs;
	}

	public void setNumOs(Integer numOs) {
		this.numOs = numOs;
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
		ServicoOs other = (ServicoOs) obj;
		return Objects.equals(id, other.id);
	}

	

	

	
	
	
}
