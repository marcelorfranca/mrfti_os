package com.mrfti.erp.domain.enums;

public enum CategoriaCnh {

	A(1, "A"),
	B(2, "B"),
	C(3, "C"),
	AB(4, "AB"),
	E(5, "E");
	
	private Integer codigo;
	private String descricao;
	
	private CategoriaCnh(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	public static CategoriaCnh toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (CategoriaCnh x  : CategoriaCnh.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Categoria inválida!");		
		
	}
	
	
}
