package com.zenrsr.capx.service;

import com.zenrsr.capx.exception.StockNotFoundException;
import com.zenrsr.capx.model.Stock;
import com.zenrsr.capx.repository.StockRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StockService {
    private final StockRepository stockRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock addStock(Stock stock) {
        LOGGER.info("Adding new stock: {}", stock);
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock not found"));
        existingStock.setName(stock.getName() != null ? stock.getName() : existingStock.getName());
        existingStock.setTicker(stock.getTicker() != null ? stock.getTicker() : existingStock.getTicker());
        existingStock.setQuantity(stock.getQuantity() > 0 ? stock.getQuantity() : existingStock.getQuantity());
        existingStock.setBuyPrice(
                stock.getBuyPrice().compareTo(BigDecimal.ZERO) > 0 ? stock.getBuyPrice() : existingStock.getBuyPrice());
        existingStock.setCurrentPrice(
                stock.getCurrentPrice().compareTo(BigDecimal.ZERO) > 0 ? stock.getCurrentPrice()
                        : existingStock.getCurrentPrice());
        existingStock
                .setProfitLoss(stock.getProfitLoss() > 0.0 ? stock.getProfitLoss() : existingStock.getProfitLoss());
        existingStock.setCat(stock.getCat() != null ? stock.getCat() : existingStock.getCat());
        LOGGER.info("Updating stock");
        return stockRepository.save(existingStock);
    }

    public void deleteStock(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock with ID " + id + " not found"));

        LOGGER.info("Deleting stock with ID: {}", id);
        stockRepository.delete(stock);

    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock with ID " + id + " not found"));

    }

    public Stock getStockByTicker(String ticker) {
        return stockRepository.findByTicker(ticker.toUpperCase())
                .orElseThrow(() -> new StockNotFoundException("Stock with ticker " + ticker + " not found"));
    }

    public List<Stock> getAllStocks() {
        LOGGER.info("Fetching all stocks");
        return stockRepository.findAll();
    }

}
