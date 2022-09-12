package com.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockapp.model.Stock;
import com.stockapp.model.Term;

@Repository
public interface ITermRepository extends JpaRepository<Term, Integer> {
	
	//Derived
	List<Term> findByTermName(String termName);
	List<Term> findAll();
}
