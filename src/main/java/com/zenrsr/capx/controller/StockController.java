package com.zenrsr.capx.controller;


import com.zenrsr.capx.model.Stock;
import com.zenrsr.capx.service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    // API to add stock
    @PostMapping
    public ResponseEntity<Stock> addStock(@Valid @RequestBody Stock stock){
        Stock createdStock = stockService.addStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }

    //API to update stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock){
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }

    //API to delete stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }

    // API to fetch stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        LOGGER.info("Fetching stock with ID: {}", id);
        Stock stock = stockService.getStockById(id);
        LOGGER.info("Stock fetched successfully: {}", stock);
        return ResponseEntity.ok(stock);
    }

    // API to fetch stock by Ticker
    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {
        LOGGER.info("Fetching stock with ticker: {}", ticker);
        Stock stock = stockService.getStockByTicker(ticker.toUpperCase());
        return  ResponseEntity.ok(stock);
    }

    // API to fetch all
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.ok(stockService.getAllStocks());
    }

}
