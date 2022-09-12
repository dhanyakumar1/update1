package com.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapp.model.Stock;
import com.stockapp.model.Term;
import com.stockapp.repository.ITermRepository;

@Service
public class TermServiceImpl implements ITermService {

	ITermRepository termRepository;
	
	@Autowired
	public void setTermRepository(ITermRepository termRepository) {
		this.termRepository = termRepository;
	}
	@Override
	public void add(Term term) {
		termRepository.save(term);
	}
	@Override
	public void update(Term term) {
		termRepository.save(term);
	}
	@Override
	public void deleteTerm(int termId) {
		termRepository.deleteById(termId);
	}
	@Override
	public List<Term> getByTermName(String termName) {
		return termRepository.findByTermName(termName);
	}
	@Override
	public List<Term> getAll() {
		return termRepository.findAll();
	}

	
	
}
