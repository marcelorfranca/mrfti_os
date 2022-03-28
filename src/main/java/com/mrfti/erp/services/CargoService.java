package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Cargo;
import com.mrfti.erp.repositories.CargoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	
	public Cargo findById(Integer id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Cargo> findAll() {
		return repository.findAll();
	}
	
	
	public Cargo create(Cargo obj) { 
		obj.setDescricao(obj.getDescricao());
		return repository.save(obj);
	}
	
	
	public Cargo update(Integer id, @Valid Cargo obj) {
		Cargo newObj = findById(id);
		newObj.setDescricao(obj.getDescricao());
		
		return repository.save(newObj);
	}
	
	
	public void delete(Integer id) { // deve ser implementado aqui no delete código p verificar se id esta atrelado a outra tabela.
		findById(id); 
		repository.deleteById(id);
		
	}
	
	
}
