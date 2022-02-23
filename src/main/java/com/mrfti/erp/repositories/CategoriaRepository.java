package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.CategoriaProduto;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaProduto, Integer>{

}
