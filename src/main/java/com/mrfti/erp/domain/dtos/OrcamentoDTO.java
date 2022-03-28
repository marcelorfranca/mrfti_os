package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.domain.Pagamento;
import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.domain.Usuario;

public class OrcamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer numOrcamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataOrcamento;
	
	private Character aprovado = 'N'; // S ou N
	private Integer desconto;
	private String observacao;
	private String contato;
	private String observacaoRecibo;
	
	private Pagamento pagamento;
	
	private Endereco enderecoOrcamento;
	
	private Setor setor;
	
	private Funcionario funcionario;
	
	private Cliente cliente;
	
	private Usuario usuario;
	
	
	
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
		this.enderecoOrcamento = obj.getEnderecoOrcamento();
		this.setor = obj.getSetor();
		this.funcionario = obj.getFuncionario();
		this.cliente = obj.getCliente();
		this.usuario = obj.getUsuario();
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

	public LocalDate getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(LocalDate dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public Character getAprovado() {
		return aprovado;
	}

	public void setAprovado(Character aprovado) {
		this.aprovado = aprovado;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
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

	public Endereco getEnderecoOrcamento() {
		return enderecoOrcamento;
	}

	public void setEnderecoOrcamento(Endereco enderecoOrcamento) {
		this.enderecoOrcamento = enderecoOrcamento;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

		
	
	
	
	
	
}


