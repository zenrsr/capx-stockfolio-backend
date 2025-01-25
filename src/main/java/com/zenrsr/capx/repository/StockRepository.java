package com.zenrsr.capx.repository;

import com.zenrsr.capx.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findByTicker(String ticker);
}
