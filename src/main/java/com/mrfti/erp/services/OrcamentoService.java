package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

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
public class OrcamentoService {

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
		
		obj.setId(null);
		obj.setDataOrcamento(obj.getDataOrcamento());
		obj.setAprovado('N');
		obj.setDesconto(obj.getDesconto());
		obj.setObservacao(obj.getObservacao());
		obj.setObservacaoRecibo(obj.getObservacaoRecibo());
		obj.setContato(obj.getContato());
		obj.setNumOrcamento(obj.getNumOrcamento()); // pegar o maior e somar 1
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
	
	public Orcamento update(Integer id, @Valid OrcamentoDTO objDTO) {
		
		objDTO.setId(id);
		
		Orcamento newObj = findById(id); // lança uma exceção caso id nao exista
		
		
			updateData(newObj, objDTO);
		
			
			
			orcamentoRepository.save(newObj);
			
			
			return newObj;
		
	}
	
	private void updateData(Orcamento newObj,OrcamentoDTO objDTO) {
		newObj.setNumOrcamento(objDTO.getNumOrcamento());
		newObj.setDataOrcamento(objDTO.getDataOrcamento());
		newObj.setAprovado(objDTO.getAprovado());
		newObj.setDesconto(objDTO.getDesconto());
		newObj.setObservacao(objDTO.getObservacao());
		newObj.setObservacaoRecibo(objDTO.getObservacaoRecibo());
		newObj.setContato(objDTO.getContato());
		newObj.setSetor(objDTO.getSetor());
		newObj.setCliente(objDTO.getCliente());
		newObj.setFuncionario(objDTO.getFuncionario());
		newObj.setPagamento(objDTO.getPagamento());
		// falta aqui pgtos, produtos e serviços
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void delete(Integer id) {
		Orcamento obj = findById(id);

		if (obj.getAprovado().equals("S")) {
			throw new DataIntegrityViolationException("Orçamento Aprovado não pode ser deletado!");
		}
		
		orcamentoRepository.deleteById(id);
	}
	
	
	
}
