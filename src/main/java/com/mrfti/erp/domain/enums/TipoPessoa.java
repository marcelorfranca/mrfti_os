package com.mrfti.erp.domain.enums;

public enum TipoPessoa {

	PESSOAFISICA(0, "PESSOAFISICA"), PESSOAJURIDICA(1, "PESSOAJURIDICA");
	
	
	private Integer codigo;
	private String descricao;
	
	private TipoPessoa(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPessoa toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoPessoa x  : TipoPessoa.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo Pessoa inválido!");		
		
	}
	
}
