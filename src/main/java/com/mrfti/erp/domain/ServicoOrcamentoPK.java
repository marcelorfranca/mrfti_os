package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ServicoOrcamentoPK implements Serializable { // classe chave comporta da classe orcamento e serviço 
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name="orcamento_id")
	private Orcamento orcamento;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	// nesta classe não usamos construtores
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orcamento, servico);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoOrcamentoPK other = (ServicoOrcamentoPK) obj;
		return Objects.equals(orcamento, other.orcamento) && Objects.equals(servico, other.servico);
	}
	
	
	
}
