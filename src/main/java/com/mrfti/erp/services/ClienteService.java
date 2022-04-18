package com.mrfti.erp.services;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Pessoa;
import com.mrfti.erp.domain.dtos.ClienteDTO;
import com.mrfti.erp.domain.enums.Perfil;
import com.mrfti.erp.repositories.ClienteRepository;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.repositories.PessoaRepository;
import com.mrfti.erp.services.exceptions.DataIntegrityViolationException;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
@Transactional
public class ClienteService {

	 @PersistenceContext
	 private EntityManager manager;

	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	
	public Cliente create(ClienteDTO objDTO) { 
		objDTO.setId(null);
		
		validaPorCpfECnpjEEmail(objDTO);	
		
		Cliente cli = new Cliente(objDTO);
		Municipio mun = new Municipio(objDTO.getMunicipioId(), null, null);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),objDTO.getBairro(), objDTO.getCep(),
									null, cli, mun);

		cli.getEnderecos().add(end);
		
		repository.save(cli);
		enderecoRepository.save(end);
		
		return cli;
		
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		
		objDTO.setId(id);
		
		Cliente newObj = findById(objDTO.getId()); // lança uma exceção caso id nao exista
		
		
		try{
			Query query = manager.createNativeQuery("DELETE FROM PERFIS WHERE PESSOA_ID = " + newObj.getId()); 
			query.executeUpdate(); 
		}catch(Exception e){
			e.printStackTrace(); }
		
			validaPorCpfECnpjEEmail(objDTO);	
			updateData(newObj, objDTO);
			
			Municipio mun = new Municipio(objDTO.getMunicipioId(), null, null);
			Endereco end = new Endereco(objDTO.getEnderecoId(), objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),objDTO.getBairro(), objDTO.getCep(),
										null, newObj, mun);
			
			newObj.getEnderecos().add(end);
			
			
			repository.save(newObj);
			enderecoRepository.save(end);
			
			
			return newObj;
		
	}
	
	private void updateData(Cliente newObj,ClienteDTO objDTO) {
		newObj.setNome(objDTO.getNome());
		newObj.setEmail(objDTO.getEmail());
		newObj.setTipoCliente(objDTO.getTipoCliente());
		newObj.setCpfOrCnpj(objDTO.getCpfOrCnpj());
		newObj.setDataInclusao(objDTO.getDataInclusao());
		newObj.setTelefone1(objDTO.getTelefone1());
		newObj.setTelefone2(objDTO.getTelefone2());
		newObj.setTelefone3(objDTO.getTelefone3());
		
		
		
		if(objDTO.getPerfil1() == null) {
			newObj.addPerfil(Perfil.CLIENTE);
		}
		else {
			newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil1()));
		}
		
		System.out.println("Valor do perfil 1:" + objDTO.getPerfil1());
		
		if(objDTO.getPerfil2() != null) {
			newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil2()));
			System.out.println("Valor do perfil 2:" + objDTO.getPerfil2());
			if(objDTO.getPerfil3() != null) {
				newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil3()));
				System.out.println("Valor do perfil 3:" + objDTO.getPerfil3());
				if(objDTO.getPerfil4() != null) {
					newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil4()));
				}
			}
		}
		
		
		if(!objDTO.getSenha().equals(newObj.getSenha())) 
			newObj.setSenha(objDTO.getSenha());
	}
	
	
	public void delete(Integer id) {
		Cliente obj = findById(id);

		if (obj.getOs().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
		}

		if (obj.getOrcamentos().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui orçamentos e não pode ser deletado!");
		}
		
		repository.deleteById(id);
	}
	
	private void validaPorCpfECnpjEEmail(ClienteDTO objDTO) {
		
		/*
		 * Optional<Cliente> obj1 = repository.findByCpfOrCnpj(objDTO.getCpfOrCnpj());
		 * if(obj1.isPresent() && obj1.get().getId() != objDTO.getId()) { throw new
		 * DataIntegrityViolationException("CPF/CNPJ já cadastrado no sistema!"); }
		 */		 
		
		
		Optional<Pessoa> obj2 = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj2.isPresent() && obj2.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("EMAIL já cadastrado no sistema!");
		}
		
	}
	
}
