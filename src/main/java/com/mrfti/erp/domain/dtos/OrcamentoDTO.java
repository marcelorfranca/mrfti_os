package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.domain.Pagamento;
import com.mrfti.erp.domain.Setor;

public class OrcamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer numOrcamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataOrcamento;
	
	private Character aprovado; // S ou N
	private Double desconto;
	private String observacao;
	private String contato;
	private String observacaoRecibo;
	
	private Pagamento pagamento;
	
	
	private Setor setor;
	
	private Funcionario funcionario;
	
	private Cliente cliente;
	
	
	public OrcamentoDTO() {
	}

	public OrcamentoDTO(Orcamento obj) {
		this.id = obj.getId();
		this.numOrcamento = obj.getNumOrcamento();
		this.dataOrcamento = obj.getDataOrcamento();
		this.aprovado = obj.getAprovado();
		this.desconto = obj.getDesconto();
		this.observacao = obj.getObservacao();
		this.contato = obj.getContato();
		this.observacaoRecibo = obj.getObservacaoRecibo();
		this.pagamento = obj.getPagamento();
		this.setor = obj.getSetor();
		this.funcionario = obj.getFuncionario();
		this.cliente = obj.getCliente();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumOrcamento() {
		return numOrcamento;
	}

	public void setNumOrcamento(Integer numOrcamento) {
		this.numOrcamento = numOrcamento;
	}

	public Date getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public Character getAprovado() {
		return aprovado;
	}

	public void setAprovado(Character aprovado) {
		this.aprovado = aprovado;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getObservacaoRecibo() {
		return observacaoRecibo;
	}

	public void setObservacaoRecibo(String observacaoRecibo) {
		this.observacaoRecibo = observacaoRecibo;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}


