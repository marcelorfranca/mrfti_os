//package com.mrfti.erp.domain;
package com.mrfti.erp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	protected Double preco;
	
	
	//Orçamento
	@JsonIgnore
	public List<Orcamento> getOrcamentos() {
		List<Orcamento> lista = new ArrayList<>();
		for (ServicoOrcamento x : servicos) {
			lista.add(x.getOrcamento());
		}
		return lista;
	}
	
	@JsonIgnore	
	@OneToMany(mappedBy="id.servico")
	private Set<ServicoOrcamento> servicos = new HashSet<>();
	
	
	
	// OS
	@JsonIgnore
	public List<Os> getOs() {
		List<Os> lista = new ArrayList<>();
		for (ServicoOs x : OSs) {
			lista.add(x.getOs());
		}
		return lista;
	}
	
	@JsonIgnore		
	@OneToMany(mappedBy="id.servico")
	private Set<ServicoOs> OSs = new HashSet<>();
	
	
	
	
	public Servico() {
	}

	public Servico(Integer id, String descricao, Double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonIgnore // ocultando na saida do postmam para test
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	public Set<ServicoOrcamento> getItens() {
		return servicos;
	}

	public void setItens(Set<ServicoOrcamento> servicos) {
		this.servicos = servicos;
	}
	

	public Set<ServicoOrcamento> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoOrcamento> servicos) {
		this.servicos = servicos;
	}

	public Set<ServicoOs> getOSs() {
		return OSs;
	}

	public void setOSs(Set<ServicoOs> oSs) {
		OSs = oSs;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

	
}
