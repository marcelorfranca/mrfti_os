package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco findById(Integer id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	
	public void delete(Integer id) { 
		findById(id); 
		repository.deleteById(id);
		
	}
	
}
