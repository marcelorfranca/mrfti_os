package com.mrfti.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByEmail(String email);
	
}
