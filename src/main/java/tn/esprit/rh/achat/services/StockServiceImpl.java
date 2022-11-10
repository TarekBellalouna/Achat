package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {

		return  stockRepository.findAll();

	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		long start = System.currentTimeMillis();

		return stockRepository.findById(stockId).orElse(null);

	}

	@Override
	public String retrieveStatusStock() {
		return null;
	}

	
}