package com.mrfti.erp.domain.enums;

public enum StatusOs {

	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), FINALIZADO(2, "FINALIZADO");
	
	private Integer codigo;
	private String descricao;
	
	private StatusOs(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusOs toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (StatusOs x  : StatusOs.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status Os inválido!");		
		
		
	}
	
	
}
