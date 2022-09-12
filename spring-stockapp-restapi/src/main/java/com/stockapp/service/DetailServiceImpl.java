package com.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockapp.model.Buyer;
import com.stockapp.model.Detail;
import com.stockapp.model.Stock;
import com.stockapp.repository.IDetailRepository;

@Service
public class DetailServiceImpl implements IDetailService {

	IDetailRepository detailRepository;
	@Autowired
	public void setDetailRepository(IDetailRepository detailRepository) {
		this.detailRepository = detailRepository;
	}
	@Override
	public void add(Detail detail) {
		detailRepository.save(detail);
	}
	@Override
	public void update(Detail detail) {
		detailRepository.save(detail);
	}
	@Override
	public void deletebyId(int detailId) {
		detailRepository.deleteById(detailId);
	}
	@Override
	public List<Detail> getByStockType(String stockType) {
		return detailRepository.findByStockType(stockType);
	}
	@Override
	public List<Detail> getByStockCurrentPrice(double price) {
		return detailRepository.findByStockCurrentPrice(price);
	}
	@Override
	public List<Detail> getAll() {
		return detailRepository.findAll();
	}
	
	
	
}
