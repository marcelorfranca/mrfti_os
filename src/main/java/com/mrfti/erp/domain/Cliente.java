package com.mrfti.erp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
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
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Cliente() {
	}

	

	public Cliente(Integer id, String nome, String email, LocalDate dataInclusao, String telefone1,String telefone2, String telefone3, String cpfOrCnpj,
			TipoCliente tipoCliente) {
		super(id, nome, email, dataInclusao,  telefone1, telefone2, telefone3);
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
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
