package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.repositories.CategoriaRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class CategoriaProdutoService {

	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaProduto findById(Integer id) {
		Optional<CategoriaProduto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<CategoriaProduto> findAll() {
		return repository.findAll();
	}
	
}
