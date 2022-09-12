package com.stockapp.service;

import java.util.List;
import com.stockapp.model.Stock;
import com.stockapp.model.Term;

public interface ITermService {

	void add(Term term);
	void update(Term term);
	void deleteTerm(int termId);
	
	
	List<Term> getByTermName(String termName);
	List<Term> getAll();
	
}
