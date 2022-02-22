package com.mrfti.erp.domain;

import java.time.LocalDate;

import com.mrfti.erp.domain.enums.TipoPessoa;

public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

		protected String matricula;
		protected char ativo;
		protected char operacional;
		protected LocalDate admissao;
		protected LocalDate demissao;
		protected String cpf;
		
		public Funcionario() {
			super();
		}

		public Funcionario(Integer id, String cpfOuCnpj, String nome, String email, TipoPessoa tipoPessoa,
				String matricula, char ativo, char operacional, LocalDate admissao, LocalDate demissao, String cpf) {
			super(id, cpfOuCnpj, nome, email, tipoPessoa);
			this.matricula = matricula;
			this.ativo = ativo;
			this.operacional = operacional;
			this.admissao = admissao;
			this.demissao = demissao;
			this.cpf = cpf;
		}

		
		

		
		
	
}
