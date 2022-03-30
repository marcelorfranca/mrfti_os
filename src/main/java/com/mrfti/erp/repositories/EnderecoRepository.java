package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	
	//@Query("delete from Endereco where FUNCIONARIO_ID like :FUNCIONARIO_ID")
	//Endereco deleteByIdEndeFunc(@Param("FUNCIONARIO_ID") Integer FUNCIONARIO_ID );
	
	
}
