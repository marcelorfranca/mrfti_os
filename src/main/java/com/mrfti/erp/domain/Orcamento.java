package com.mrfti.erp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orcamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	
	@Column(unique = true)
	private Integer numOrcamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataOrcamento;
	
	private Character aprovado = 'N'; // S ou N
	private Integer desconto;
	private String observacao;
	private String contato;
	private String observacaoRecibo;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="orcamento")
	private Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name="endereco_orcamento_id")
	private Endereco enderecoOrcamento;
	
	@ManyToOne
	@JoinColumn(name = "setor_id") // relacionando as classes
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id") // relacionando as classes
	private Funcionario funcionario;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	@OneToMany(mappedBy="id.orcamento")
	private Set<ItemOrcamento> itens = new HashSet<>();
	
	@OneToMany(mappedBy="id.orcamento")
	private Set<ServicoOrcamento> servicos = new HashSet<>();
	
	public Orcamento() {
	}

	public Orcamento(Integer id, Integer numOrcamento, LocalDate dataOrcamento, Character aprovado, Integer desconto,
			String observacao, String contato, String observacaoRecibo, Endereco enderecoOrcamento, Setor setor,
			Funcionario funcionario, Cliente cliente, Usuario usuario) {
		super();
		this.id = id;
		this.numOrcamento = numOrcamento;
		this.dataOrcamento = dataOrcamento;
		this.aprovado = aprovado;
		this.desconto = desconto;
		this.observacao = observacao;
		this.contato = contato;
		this.observacaoRecibo = observacaoRecibo;
		this.enderecoOrcamento = enderecoOrcamento;
		this.setor = setor;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.usuario = usuario;
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

	
	public Set<ItemOrcamento> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrcamento> itens) {
		this.itens = itens;
	}
	
	
	public Set<ServicoOrcamento> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoOrcamento> servicos) {
		this.servicos = servicos;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
}
