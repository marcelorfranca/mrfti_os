package com.mrfti.erp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Pessoa;
import com.mrfti.erp.domain.dtos.FuncionarioDTO;
import com.mrfti.erp.domain.enums.Perfil;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.repositories.FuncionarioRepository;
import com.mrfti.erp.repositories.PessoaRepository;
import com.mrfti.erp.services.exceptions.DataIntegrityViolationException;
import com.mrfti.erp.services.exceptions.ObjectnotFoundException;

@Service
@Transactional
public class FuncionarioService {
	
	 @PersistenceContext
	 private EntityManager manager;

	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! Id: " + id));
	}

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	public Funcionario create(FuncionarioDTO objDTO) { // converter as infos para novo funcionario
		objDTO.setId(null); // assegurando que o ID virá nulo, senao ele pensará que é um update
		
		
		validaPorCpfEEmailECnh(objDTO);	
		
		Funcionario func = new Funcionario(objDTO);
		Municipio mun = new Municipio(objDTO.getMunicipioId(), null, null);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),objDTO.getBairro(), objDTO.getCep(),
									func, null, mun);

		func.getEnderecos().add(end);
		
		repository.save(func);
		enderecoRepository.save(end);
		
		return func;
		
	}
	
	public Funcionario update(Integer id, @Valid FuncionarioDTO objDTO) {
		
		objDTO.setId(id);
		
		Funcionario newObj = findById(id); // lança uma exceção caso id nao exista
		
		try{
				Query query = manager.createNativeQuery("DELETE FROM PERFIS WHERE PESSOA_ID = " + newObj.getId()); // limpa a tabela perfis do func atual, evitando duplicidade
				query.executeUpdate(); 
		 }catch(Exception e){
		 e.printStackTrace(); }
		 
		
		
			validaPorCpfEEmailECnh(objDTO);	
			updateData(newObj, objDTO);
			
			Municipio mun = new Municipio(objDTO.getMunicipioId(), null, null);
			Endereco end = new Endereco(objDTO.getEnderecoId(), objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),objDTO.getBairro(), objDTO.getCep(),
										newObj, null, mun);
			
			newObj.getEnderecos().add(end);
			
			
			repository.save(newObj);
			enderecoRepository.save(end);
			
			
			return newObj;
		
	}
	
	private void updateData(Funcionario newObj,FuncionarioDTO objDTO) {
		newObj.setNome(objDTO.getNome());
		newObj.setEmail(objDTO.getEmail());
		newObj.setCpf(objDTO.getCpf());
		newObj.setDataInclusao(objDTO.getDataInclusao());
		newObj.setMatricula(objDTO.getMatricula());
		newObj.setAtivo(objDTO.getAtivo());
		newObj.setOperacional(objDTO.getOperacional());
		newObj.setAdmissao(objDTO.getAdmissao());
		newObj.setCnh(objDTO.getCnh());
		newObj.setCargo(objDTO.getCargo());
		newObj.setSetor(objDTO.getSetor());
		newObj.setTelefone1(objDTO.getTelefone1());
		newObj.setTelefone2(objDTO.getTelefone2());
		newObj.setTelefone3(objDTO.getTelefone3());
		newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil1()));
		
		if(objDTO.getPerfil1() == null) {
			newObj.addPerfil(Perfil.TECNICO);
		}else {
			newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil1()));
		}
		
		
		if(objDTO.getPerfil2() != null) {
			newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil2()));
			if(objDTO.getPerfil3() != null) {
				newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil3()));
				if(objDTO.getPerfil4() != null) {
					newObj.addPerfil(Perfil.toEnum(objDTO.getPerfil4()));
				}
			}
		}
			
		
		if(!objDTO.getSenha().equals(newObj.getSenha()))  // verifica se senha não é igual a que veio do banco, se for deve ser gravada pois foi alterada.
			newObj.setSenha(objDTO.getSenha());
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
		if(obj2.isPresent() && obj2.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("EMAIL já cadastrado no sistema!");
		}
		
		Optional<Funcionario> obj3 = repository.findByCnh(objDTO.getCnh());
		if(obj3.isPresent() && obj3.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CNH já cadastrado no sistema!");
		}
		
	}
	
	
}
