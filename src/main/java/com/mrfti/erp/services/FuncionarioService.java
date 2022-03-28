package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Pessoa;
import com.mrfti.erp.domain.dtos.FuncionarioDTO;
import com.mrfti.erp.repositories.FuncionarioRepository;
import com.mrfti.erp.repositories.PessoaRepository;
import com.mrfti.erp.services.exceptions.DataIntegrityViolationException;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	public Funcionario create(FuncionarioDTO objDTO) { // converter as infos para novo funcionario
		objDTO.setId(null); // assegurando que o ID virá nulo, senao ele pensará que é um update
		objDTO.setNome(objDTO.getNome());
		objDTO.setEmail(objDTO.getEmail());
		objDTO.setCpf(objDTO.getCpf());
		objDTO.setDataInclusao(objDTO.getDataInclusao());
		objDTO.setMatricula(objDTO.getMatricula());
		objDTO.setAtivo(objDTO.getAtivo());
		objDTO.setOperacional(objDTO.getOperacional());
		objDTO.setAdmissao(objDTO.getAdmissao());
		objDTO.setDemissao(objDTO.getDemissao());
		objDTO.setFotoCnh(objDTO.getFotoCnh());
		objDTO.setCargo(objDTO.getCargo());
		objDTO.setSetor(objDTO.getSetor());
		objDTO.setTelefone1(objDTO.getTelefone1());
		objDTO.setTelefone2(objDTO.getTelefone2());
		objDTO.setTelefone3(objDTO.getTelefone3());
		
		
		validaPorCpfEEmailECnh(objDTO);	
		
		Funcionario newObj = new Funcionario(objDTO);
		

		return repository.save(newObj);
	}
	
	public Funcionario update(Integer id, @Valid FuncionarioDTO objDTO) {
		objDTO.setId(id);
		Funcionario oldObj = findById(id); // lança uma exceção caso id nao exista
		
			validaPorCpfEEmailECnh(objDTO);	
		
			oldObj = new Funcionario(objDTO);
			return repository.save(oldObj);
		
	}
	
	
	public void delete(Integer id) {
		Funcionario obj = findById(id);

		if (obj.getOs().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
		}

		if (obj.getOrcamentos().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui orçamentos e não pode ser deletado!");
		}
		
		repository.deleteById(id);
	}
	
	private void validaPorCpfEEmailECnh(FuncionarioDTO objDTO) {
		Optional<Funcionario> obj = repository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		
		Optional<Pessoa> obj2 = pessoaRepository.findByEmail(objDTO.getEmail());
		obj2 = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj2.isPresent() && obj2.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("EMAIL já cadastrado no sistema!");
		}
		
		Optional<Funcionario> obj3 = repository.findByCnh(objDTO.getCnh());
		obj3 = repository.findByCnh(objDTO.getCnh());
		if(obj3.isPresent() && obj3.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CNH já cadastrado no sistema!");
		}
		
	}
	
	
}
