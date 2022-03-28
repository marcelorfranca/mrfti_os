package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Veiculo;
import com.mrfti.erp.repositories.VeiculoRepository;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Veiculo> findAll() {
		return repository.findAll();
	}
	
}
