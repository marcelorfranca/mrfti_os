package com.mrfti.erp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario extends Pessoa{

	private static final long serialVersionUID = 1L;

		
		protected String matricula;
		protected char ativo;
		protected char operacional;
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate admissao;
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate demissao;
		@CPF
		@Column(unique = true)
		protected String cpf;
		
		@JsonIgnore
		@OneToMany(mappedBy = "funcionario") // um funcionaio para muitas OSs
		private List<Os> os = new ArrayList<>();
		
		@JsonIgnore
		@OneToMany(mappedBy = "funcionario") // um func para muitos orcamentos
		private List<Orcamento> orcamentos = new ArrayList<>();
		
		@ElementCollection
		@CollectionTable(name="TELEFONE_FUNCIONARIO") // cria uma tabela
		private Set<String> telefones = new HashSet<>(); // entidade fraca
		
		public Funcionario() {
		}
		
	
}
