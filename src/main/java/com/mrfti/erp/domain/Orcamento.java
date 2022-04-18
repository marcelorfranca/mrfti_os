package com.mrfti.erp.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
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
import com.mrfti.erp.domain.dtos.OrcamentoDTO;

@Entity
public class Orcamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(unique = true)
	private Integer numOrcamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataOrcamento;
	
	private Character aprovado; // S ou N
	private Double desconto;
	private String observacao;
	private String contato;
	private String observacaoRecibo;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="orcamento")
	private Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name = "setor_id") // relacionando as classes
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id") // relacionando as classes
	private Funcionario funcionario;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	
	
	@OneToMany(mappedBy="id.orcamento")
	private Set<ItemOrcamento> itens = new HashSet<>();
	
	@OneToMany(mappedBy="id.orcamento")
	private Set<ServicoOrcamento> servicos = new HashSet<>();
	
	public Orcamento() {
	}

	public Orcamento(Integer id, Integer numOrcamento, Date dataOrcamento, Character aprovado, Double desconto,
			String observacao, String contato, String observacaoRecibo, Endereco enderecoOrcamento, Setor setor,
			Funcionario funcionario, Cliente cliente) {
		super();
		this.id = id;
		this.numOrcamento = numOrcamento;
		this.dataOrcamento = dataOrcamento;
		this.aprovado = aprovado;
		this.desconto = desconto;
		this.observacao = observacao;
		this.contato = contato;
		this.observacaoRecibo = observacaoRecibo;
		this.setor = setor;
		this.funcionario = funcionario;
		this.cliente = cliente;
	}

	
	public Orcamento(OrcamentoDTO obj) {
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
	
	public double getValorTotal() {
		double soma = 0.0;
		for (ItemOrcamento ip : itens) {
			soma = soma + ip.getSubTotal();
		}
		for (ServicoOrcamento sp : servicos){
			soma = soma + sp.getSubTotal();
		}
		return soma;
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

	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Orçamento número: ");
		builder.append(getNumOrcamento());
		builder.append(", Data do orçamento: ");
		builder.append(sdf.format(getDataOrcamento()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getEstadoPgto());
		builder.append("\nDetalhes:\n");
		for (ItemOrcamento io : getItens()) {
			builder.append(io.toString());
		}
		for (ServicoOrcamento so : getServicos()) {
			builder.append(so.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}
	
	
	
}
