package com.mrfti.erp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrfti.erp.domain.enums.TipoCliente;

@Entity
public class Cliente extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String cpfOrCnpj;
	private TipoCliente tipoCliente;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente") // um cliente para muitas OSs
	private List<Os> os = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente") // um cliente para muitos orcamentos
	private List<Orcamento> orcamentos = new ArrayList<>();
	
	
	
	@ElementCollection
	@CollectionTable(name="TELEFONE_CLIENTE")
	private Set<String> telefones = new HashSet<>(); // entidade fraca
	
	public Cliente() {
	}

	

	public Cliente(Integer id, String nome, String email, LocalDate dataInclusao, String cpfOrCnpj,
			TipoCliente tipoCliente) {
		super(id, nome, email, dataInclusao);
		this.cpfOrCnpj = cpfOrCnpj;
		this.tipoCliente = tipoCliente;
	}



	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Os> getOs() {
		return os;
	}

	public void setOs(List<Os> os) {
		this.os = os;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpfOrCnpj);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfOrCnpj, other.cpfOrCnpj);
	}

	
	
}
