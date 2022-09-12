package com.stockapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapp.model.Stock;
import com.stockapp.service.IStockService;

@RestController
@RequestMapping("stocks-api")
public class StockController {
	
	IStockService stockService;

	@Autowired
	public void setStockService(IStockService stockService) {
		this.stockService = stockService;
	}
	
	// stocks-api/addstock
	@PostMapping("/addstock")
	public ResponseEntity<Void> addStock( Stock stock) {
		stockService.addStock(stock);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Add one stock");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}
	
	//stocks-api/updatestock
	@PutMapping("/updatestock")
	public ResponseEntity<String> updateStock( Stock stock) {
		stockService.updateStock(stock);
		return ResponseEntity.accepted().body("updated");
	}
	
	//stocks-api/deletestock/1
	@DeleteMapping("deletestock/{stockId}")
	public ResponseEntity<Void> deleteStock(@PathVariable("stockId") int stockId) {
		stockService.deleteStock(stockId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// stocks-api/stocks
	@GetMapping("/stocks")
	public ResponseEntity<List<Stock>> getAll(){
		// response body
		List<Stock> stocks = stockService.getAll();
		HttpHeaders headers = new HttpHeaders();
		// response headers
		headers.add("desc", "All stocks");
		headers.add("info", "Getting investments from db");
		ResponseEntity<List<Stock>> responseEntity = new ResponseEntity<List<Stock>>(stocks, headers, HttpStatus.OK);
		return responseEntity;
	}
	
//	
//	@GetMapping("/investments/risk/{risk}/term/{term}")
//	public ResponseEntity<List<Investment>> getByRiskAndTerm
//			(@PathVariable("risk") String risk, @PathVariable("term") int mterm ) {
//		List<Investment> investments = investmentService.getByRiskAndTerm(risk, mterm);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "All investments by risk and term");
//		headers.add("info", "investments REST API by term and risk");
//		
//		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
//	}
	
	

}
