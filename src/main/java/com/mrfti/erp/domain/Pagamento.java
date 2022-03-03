package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.mrfti.erp.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) // JOINED ele cria uma tabela para cada subclasse, single_table = cria um tabelao
public abstract class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer estadoPgto;
	
	@OneToOne
	@JoinColumn(name="orcamento_id")
	@MapsId
	private Orcamento orcamento;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estadoPgto, Orcamento orcamento) {
		super();
		this.id = id;
		this.estadoPgto = estadoPgto.getCodigo();
		this.orcamento = orcamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPgto() {
		return EstadoPagamento.toEnum(estadoPgto);
	}

	public void setEstadoPgto(EstadoPagamento estadoPgto) {
		this.estadoPgto = estadoPgto.getCodigo();
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
