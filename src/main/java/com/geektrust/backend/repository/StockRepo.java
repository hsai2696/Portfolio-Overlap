package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Stock;

import java.util.HashMap;
import java.util.Map;

public class StockRepo implements IStockRepo{
    private Map<String,Stock> stockData;
    private Integer autoIncrement = 0;

    public StockRepo(){
        this.stockData = new HashMap<>();
    }
    @Override
    public Stock save(Stock stock) {
        Stock resultant;
        if(stock.getId()==null){
            Stock newStock = new Stock(Integer.toString(autoIncrement++),stock.getName());
            stockData.put(newStock.getId(), newStock);
            resultant = newStock;
        }else{
            stockData.put(stock.getId(), stock);
            resultant = stock;
        }
        return  resultant;
    }

    @Override
    public Stock getByID(String stockId) {
        return stockData.get(stockId);
    }
}
