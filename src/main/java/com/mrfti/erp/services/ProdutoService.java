package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.repositories.ProdutoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
}
