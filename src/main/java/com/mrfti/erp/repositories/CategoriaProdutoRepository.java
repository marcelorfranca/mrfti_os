package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.CategoriaProduto;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer>{

}
