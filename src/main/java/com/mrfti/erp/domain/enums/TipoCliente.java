package com.mrfti.erp.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "PESSOAFISICA"), PESSOAJURIDICA(2, "PESSOAJURIDICA");
	
	
	private Integer codigo;
	private String descricao;
	
	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente x  : TipoCliente.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo Pessoa inválido!");		
		
	}
	
}
