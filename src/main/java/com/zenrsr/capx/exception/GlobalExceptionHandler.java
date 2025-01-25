package com.zenrsr.capx.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<String> handleStockFoundException(StockNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
