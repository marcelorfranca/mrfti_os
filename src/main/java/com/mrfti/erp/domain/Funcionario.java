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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario extends Pessoa{

	private static final long serialVersionUID = 1L;

		
		protected String matricula;
		protected Character ativo;
		protected Character operacional;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate admissao;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate demissao;
		
		@CPF
		@Column(unique = true)
		protected String cpf;
		
		@Column(unique = true)
		private String cnh;
		
		private String fotoCnh;
		
		
		@JsonIgnore
		@OneToMany(mappedBy = "funcionario") // um funcionaio para muitas OSs
		private List<Os> os = new ArrayList<>();
		
		@JsonIgnore
		@OneToMany(mappedBy = "funcionario") // um func para muitos orcamentos
		private List<Orcamento> orcamentos = new ArrayList<>();
		
		@ElementCollection
		@CollectionTable(name="TELEFONE_FUNCIONARIO") // cria uma tabela
		private Set<String> telefones = new HashSet<>(); // entidade fraca
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name = "setor_id") // relacionando as classes
		private Setor setor;
		
		
		@ManyToOne
		@JoinColumn(name = "cargo_id") 
		private Cargo cargo;
		
		
		@JsonIgnore
		@OneToMany(mappedBy = "funcionario") // um funcionario para varios veiculos
		private List<Veiculo> veiculos = new ArrayList<>();
		
		
		public Funcionario() {
		}

		
		
		
		public Funcionario(Integer id, String nome, String email, LocalDate dataInclusao, String matricula, Character ativo,
				Character operacional, LocalDate admissao, LocalDate demissao, @CPF String cpf, String cnh , String fotoCnh , Setor setor, Cargo cargo) {
			super(id, nome, email, dataInclusao);
			this.matricula = matricula;
			this.ativo = ativo;
			this.operacional = operacional;
			this.admissao = admissao;
			this.demissao = demissao;
			this.cpf = cpf;
			this.setor = setor;
			this.cargo = cargo;
			this.cnh = cnh;
			this.fotoCnh = fotoCnh;
		}

		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}


		public Character getAtivo() {
			return ativo;
		}
		public void setAtivo(Character ativo) {
			this.ativo = ativo;
		}


		public Character getOperacional() {
			return operacional;
		}
		public void setOperacional(Character operacional) {
			this.operacional = operacional;
		}


		public LocalDate getAdmissao() {
			return admissao;
		}
		public void setAdmissao(LocalDate admissao) {
			this.admissao = admissao;
		}


		public LocalDate getDemissao() {
			return demissao;
		}
		public void setDemissao(LocalDate demissao) {
			this.demissao = demissao;
		}


		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
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

		@JsonIgnore
		public Setor getSetor() {
			return setor;
		}
		public void setSetor(Setor setor) {
			this.setor = setor;
		}

		@JsonIgnore
		public Cargo getCargo() {
			return cargo;
		}
		
		
		public void setCargo(Cargo cargo) {
			this.cargo = cargo;
		}

		
		public List<Veiculo> getVeiculos() {
			return veiculos;
		}
		public void setVeiculos(List<Veiculo> veiculos) {
			this.veiculos = veiculos;
		}
		
		
		public String getCnh() {
			return cnh;
		}
		public void setCnh(String cnh) {
			this.cnh = cnh;
		}


		public String getFotoCnh() {
			return fotoCnh;
		}
		public void setFotoCnh(String fotoCnh) {
			this.fotoCnh = fotoCnh;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(cpf);
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
			Funcionario other = (Funcionario) obj;
			return Objects.equals(cpf, other.cpf);
		}
		
	
		
		
}
