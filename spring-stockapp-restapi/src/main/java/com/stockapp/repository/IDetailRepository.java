package com.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockapp.model.Buyer;
import com.stockapp.model.Detail;
import com.stockapp.model.Stock;

@Repository
public interface IDetailRepository extends JpaRepository<Detail, Integer> {
	
	//Custom querry
//	@Query("from Detail where stockType=?1")
//	List<Detail> findByStockType(String stockType);
//	
//	@Query("from Detail where stockCurrentPrice=?1")
//	List<Detail> findByStockCurrentPrice(double price);

  //Derived Querry
	List<Detail> findByStockType(String stockType);
	List<Detail> findByStockCurrentPrice(double price);
	List<Detail> findAll();
	
	
	
}
