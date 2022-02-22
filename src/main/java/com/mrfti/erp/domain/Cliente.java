package com.mrfti.erp.domain;

import com.mrfti.erp.domain.enums.TipoPessoa;

public class Cliente extends Pessoa{

	private static final long serialVersionUID = 1L;

	protected String cpfOrCnpj;
	
	
	public Cliente() {
		super();
	}


	public Cliente(Integer id, String cpfOuCnpj, String nome, String email, TipoPessoa tipoPessoa, String cpfOrCnpj) {
		super(id, cpfOuCnpj, nome, email, tipoPessoa);
		this.cpfOrCnpj = cpfOrCnpj;
	}
	
	
	
	
}
