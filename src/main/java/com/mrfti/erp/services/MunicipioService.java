package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.repositories.MunicipioRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repository;
	
	
	public Municipio findById(Integer id) {
		Optional<Municipio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Municipio> findAll() {
		return repository.findAll();
	}
	
}
