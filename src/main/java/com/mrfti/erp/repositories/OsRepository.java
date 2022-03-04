package com.mrfti.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrfti.erp.domain.Os;

@Repository
public interface OsRepository extends JpaRepository<Os, Integer> {

}
