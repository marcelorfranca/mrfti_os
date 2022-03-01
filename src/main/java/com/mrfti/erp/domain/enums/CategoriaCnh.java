package com.mrfti.erp.domain.enums;

public enum CategoriaCnh {

	A(0, "ROLE_A"),
	B(1, "ROLE_B"),
	C(2, "ROLE_C"),
	AB(3, "ROLE_AB"),
	E(4, "ROLE_E");
	
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
