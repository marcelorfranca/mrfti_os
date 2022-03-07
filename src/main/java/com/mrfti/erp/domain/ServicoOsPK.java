package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ServicoOsPK implements Serializable { // classe chave comporta da classe OS e serviço 
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="os_id")
	private Os os;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	// nesta classe não usamos construtores
	
	public Os getOs() {
		return os;
	}
	public void setOs(Os os) {
		this.os = os;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(os, servico);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoOsPK other = (ServicoOsPK) obj;
		return Objects.equals(os, other.os) && Objects.equals(servico, other.servico);
	}
	
	
	
	
	
}
