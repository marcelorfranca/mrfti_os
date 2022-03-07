package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.repositories.OrcamentoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class OrcamentoService {

	@Autowired
	private OrcamentoRepository repository;
	
	public Orcamento findById(Integer id) {
		Optional<Orcamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Orcamento> findAll() {
		return repository.findAll();
	}
	
}
