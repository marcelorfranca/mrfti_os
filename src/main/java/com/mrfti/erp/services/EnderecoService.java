package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	
	public Endereco create(Endereco objDTO) {
		objDTO.setId(null); // assegurando que o ID virá nulo, senao ele pensará que é um update
		objDTO.setLogradouro(objDTO.getLogradouro());
		objDTO.setNumero(objDTO.getNumero());
		objDTO.setComplemento(objDTO.getComplemento());
		objDTO.setCep(objDTO.getCep());
		objDTO.setBairro(objDTO.getBairro());
		objDTO.setMunicipio(objDTO.getMunicipio());
		objDTO.setFuncionario(objDTO.getFuncionario());
		objDTO.setCliente(objDTO.getCliente());
		return repository.save(objDTO);
	}
	
	
	public Endereco update(Integer id, @Valid Endereco objDTO) {
		Endereco newObj = findById(id);
		newObj.setLogradouro(objDTO.getLogradouro());
		newObj.setNumero(objDTO.getNumero());
		newObj.setComplemento(objDTO.getComplemento());
		newObj.setCep(objDTO.getCep());
		newObj.setBairro(objDTO.getBairro());
		newObj.setMunicipio(objDTO.getMunicipio());
		newObj.setFuncionario(objDTO.getFuncionario());
		newObj.setCliente(objDTO.getCliente());
		
		
		return repository.save(newObj);
	}
	
	
	public void delete(Integer id) { 
		findById(id); 
		repository.deleteById(id);
		
	}
	
}
