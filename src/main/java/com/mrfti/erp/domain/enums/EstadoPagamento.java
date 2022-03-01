package com.mrfti.erp.domain.enums;

public enum EstadoPagamento {

	PENDENTE(0, "PENDENTE"), QUITADO(1, "QUITADO"), CANCELADO(2, "CANCELADO");
	
	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (EstadoPagamento x  : EstadoPagamento.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Estado do Pagamento inválido!");		
		
	}
	
}
