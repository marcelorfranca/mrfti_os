package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.repositories.CategoriaProdutoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository repository;
	
	public CategoriaProduto findById(Integer id) {
		Optional<CategoriaProduto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<CategoriaProduto> findAll() {
		return repository.findAll();
	}
	
	
	public CategoriaProduto create(CategoriaProduto obj) {
		obj.setNome(obj.getNome());
		return repository.save(obj);
	}
	
	
	public CategoriaProduto update(Integer id, @Valid CategoriaProduto obj) {
		CategoriaProduto newObj = findById(id);
		newObj.setNome(obj.getNome());
		
		return repository.save(newObj);
	}
	
	
	public void delete(Integer id) { 
		findById(id); 
		repository.deleteById(id);
		
	}
	
}
