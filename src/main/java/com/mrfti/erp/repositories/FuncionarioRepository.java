package com.mrfti.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Funcionario;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Integer> {

	Optional<Funcionario> findByCpf(String cpf);
	Optional<Funcionario> findByCnh(String cnh);
	
}
