package com.mrfti.erp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrfti.erp.domain.enums.CategoriaCnh;

@Entity
public class Habilitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cnh;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vencimento;
	private String foto; // foto da carteira cnh
	private CategoriaCnh categoriaCnh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "habilitacao") // um cargo para muitos funcionarios
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Habilitacao() {
	}

	public Habilitacao(Integer id, String cnh, LocalDate vencimento, String foto, CategoriaCnh categoriaCnh) {
		super();
		this.id = id;
		this.cnh = cnh;
		this.vencimento = vencimento;
		this.foto = foto;
		this.categoriaCnh = categoriaCnh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public CategoriaCnh getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(CategoriaCnh categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
		Habilitacao other = (Habilitacao) obj;
		return Objects.equals(id, other.id);
	}



	
	
	
}
