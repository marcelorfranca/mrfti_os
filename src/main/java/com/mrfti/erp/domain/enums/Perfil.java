package com.mrfti.erp.domain.enums;



public enum Perfil {

	ADMIN(0, "ROLE_ADMIN"), 
	TECNICO(1, "ROLE_TECNICO"),
	CLIENTE(2, "ROLE_CLIENTE"),
	USER_OS(3, "ROLE_USER_OS"), 
	USER_ESTOQUE(4, "ROLE_USER_ESTOQUE"),
	USER_FINANCEIRO(5, "ROLE_USER_FINANCEIRO"),
	USER_VENDAS(6, "ROLE_USER_VENDAS"),
	USER_FROTA(7, "ROLE_USER_FROTA");

	
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
