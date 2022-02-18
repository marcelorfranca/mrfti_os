package com.mrfti.erp.domain.enums;

public enum ResultadoOs {

	AUSENTE(0, "AUSENTE"),
	CANCELADO(1, "CANCELADO"),
	GARANTIA(2, "GARANTIA"),
	REALIZADO(3, "REALIZADO"),
	REAGENDADO(4, "REAGENDADO"),
	NAO_REALIZADO(5, "NAO_REALIZADO");
	
	private Integer codigo;
	private String descricao;
	
	private ResultadoOs(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ResultadoOs toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (ResultadoOs x  : ResultadoOs.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Resultado de Os inválido!");		
		
		
	}
	
	
	
	
	
	
}
