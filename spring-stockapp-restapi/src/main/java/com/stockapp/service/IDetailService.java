package com.stockapp.service;

import java.util.List;

import com.stockapp.model.Buyer;
import com.stockapp.model.Detail;
import com.stockapp.model.Stock;

public interface IDetailService {
	
	void add(Detail detail);
	void update(Detail detail);
	void deletebyId(int detailId);
	
//	//derived querry
	List<Detail> getByStockType(String stockType);
	List<Detail> getByStockCurrentPrice(double price);
	List<Detail> getAll();
	
}
