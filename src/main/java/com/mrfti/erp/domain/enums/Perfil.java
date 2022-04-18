package com.mrfti.erp.domain.enums;



public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"), 
	TECNICO(2, "ROLE_TECNICO"),
	CLIENTE(3, "ROLE_CLIENTE"),
	OS(4, "ROLE_USER_OS"), 
	ESTOQUE(5, "ROLE_USER_ESTOQUE"),
	FINANCEIRO(6, "ROLE_USER_FINANCEIRO"),
	VENDAS(7, "ROLE_USER_VENDAS"),
	FROTA(8, "ROLE_USER_FROTA");

	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido!");		
	}
	
	
	
	
}
