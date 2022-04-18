package com.mrfti.erp.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mrfti.erp.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer numDeParcelas;
	
	public PagamentoComCartao() {
	}



	public PagamentoComCartao(Integer id, EstadoPagamento estadoPgto, Orcamento orcamento, Integer numDeParcelas) {
		super(id, estadoPgto, orcamento);
		this.numDeParcelas = numDeParcelas;
	}


	public Integer getNumDeParcelas() {
		return numDeParcelas;
	}

	public void setNumDeParcelas(Integer numDeParcelas) {
		this.numDeParcelas = numDeParcelas;
	}

	
	
}
