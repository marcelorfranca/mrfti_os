package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Servico;
import com.mrfti.erp.repositories.ServicoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	
	public Servico findById(Integer id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Servico> findAll() {
		return repository.findAll();
	}
	
}
