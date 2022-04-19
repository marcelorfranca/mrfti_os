package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrfti.erp.domain.ItemOrcamento;
import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.domain.ServicoOrcamento;
import com.mrfti.erp.domain.dtos.OrcamentoDTO;
import com.mrfti.erp.repositories.ItemOrcamentoRepository;
import com.mrfti.erp.repositories.OrcamentoRepository;
import com.mrfti.erp.repositories.PagamentoRepository;
import com.mrfti.erp.repositories.ServicoOrcamentoRepository;
import com.mrfti.erp.services.exceptions.DataIntegrityViolationException;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
@Transactional
public class OrcamentoService {
	
	 @PersistenceContext
	 private EntityManager manager;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ItemOrcamentoRepository itemOrcamentoRepository;
	
	@Autowired
	private ServicoOrcamentoRepository servicoOrcamentoRepository;
	
	
	public Orcamento findById(Integer id) {
		Optional<Orcamento> obj = orcamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Orcamento> findAll() {
		return orcamentoRepository.findAll();
	}
	
	
	public Page<Orcamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return orcamentoRepository.findAll(pageRequest);
	}
	
	
	
	@Transactional
	public Orcamento insert(Orcamento obj) {
	
		
		Integer maxId = orcamentoRepository.findAll().stream().map(Orcamento::getNumOrcamento).max(Integer::compare).orElse(0);// captura o maior numOrcamento
		
		obj.setId(null);
		obj.setDataOrcamento(obj.getDataOrcamento());
		obj.setAprovado(null);
		obj.setDesconto(obj.getDesconto());
		obj.setObservacao(obj.getObservacao());
		obj.setObservacaoRecibo(obj.getObservacaoRecibo());
		obj.setContato(obj.getContato());
		obj.setNumOrcamento(maxId + 1); 
		obj.setSetor(obj.getSetor());
		obj.setFuncionario(obj.getFuncionario());
		obj.setCliente(obj.getCliente());
		
		
		obj = orcamentoRepository.save(obj);

		for (ItemOrcamento io : obj.getItens()) {
			io.setDesconto(io.getDesconto());
			io.setProduto(produtoService.findById(io.getProduto().getId()));
			io.setPreco(io.getPreco());
			io.setQuantidade(io.getQuantidade());
			io.setNumOrcamento(obj.getNumOrcamento());
			io.setOrcamento(obj);
		}
		
		itemOrcamentoRepository.saveAll(obj.getItens());
		
		for (ServicoOrcamento so : obj.getServicos()) {
			so.setDesconto(so.getDesconto());
			so.setServico(servicoService.findById(so.getIdServico()));
			so.setPreco(so.getPreco());
			so.setQuantidade(so.getQuantidade());
			so.setNumOrcamento(obj.getNumOrcamento());
			so.setOrcamento(obj);
		}
		
		servicoOrcamentoRepository.saveAll(obj.getServicos());
		
		return obj;
	}
	
	public Orcamento update(Integer id, @Valid Orcamento obj) {
		
		obj.setId(id);
		
		Orcamento newObj = findById(id); // lança uma exceção caso id nao exista
		
			
		LimparItensEServicos(newObj);
			
			
			for (ItemOrcamento io : obj.getItens()) {
				io.setDesconto(io.getDesconto());
				io.setProduto(produtoService.findById(io.getProduto().getId()));
				io.setPreco(io.getPreco());
				io.setQuantidade(io.getQuantidade());
				io.setNumOrcamento(obj.getNumOrcamento());
				io.setOrcamento(obj);
			}
			
			itemOrcamentoRepository.saveAll(obj.getItens());
			
			for (ServicoOrcamento so : obj.getServicos()) {
				so.setDesconto(so.getDesconto());
				so.setServico(servicoService.findById(so.getIdServico()));
				so.setPreco(so.getPreco());
				so.setQuantidade(so.getQuantidade());
				so.setNumOrcamento(obj.getNumOrcamento());
				so.setOrcamento(obj);
			}
			
			servicoOrcamentoRepository.saveAll(obj.getServicos());
			
			
		
			updateData(newObj, obj);
		
			
			
			orcamentoRepository.save(newObj);
			
			
			return newObj;
		
	}
	
	private void updateData(Orcamento newObj,Orcamento obj) {
		newObj.setDataOrcamento(obj.getDataOrcamento());
		newObj.setAprovado(obj.getAprovado());
		newObj.setDesconto(obj.getDesconto());
		newObj.setObservacao(obj.getObservacao());
		newObj.setObservacaoRecibo(obj.getObservacaoRecibo());
		newObj.setContato(obj.getContato());
		newObj.setSetor(obj.getSetor());
		newObj.setCliente(obj.getCliente());
		newObj.setFuncionario(obj.getFuncionario());
		newObj.setPagamento(obj.getPagamento());
		
		
	}
	
	
	public void delete(Integer id) {
		Orcamento obj = findById(id);

		if (obj.getAprovado() != null) {
			if (obj.getAprovado() == 'S') {
				throw new DataIntegrityViolationException("Orçamento Aprovado não pode ser deletado!");
			}
		}
		LimparItensEServicos(obj);
		
		orcamentoRepository.deleteById(id);
	}
	
	// deleta Itens e serviços do orçamento vinculado ao Orçamento atual 
	public void LimparItensEServicos(Orcamento newObj) {
		
		try{ 
		 	 Query query = manager.createNativeQuery("DELETE FROM ITEM_ORCAMENTO WHERE ORCAMENTO_ID = " +
			  newObj.getId()); query.executeUpdate(); }catch(Exception e){
				  		e.printStackTrace(); }
			try{ 
			 	 Query query = manager.createNativeQuery("DELETE FROM SERVICO_ORCAMENTO WHERE ORCAMENTO_ID = " +
				  newObj.getId()); query.executeUpdate(); }catch(Exception e){
					  		e.printStackTrace(); }
		
	}
	
	
}
