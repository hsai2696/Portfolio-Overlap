package com.geektrust.backend.entity;

import java.util.List;

public class MutualFund {

    private String id;
    private String name;
    private List<Stock> stocks;


    public MutualFund(String name, List<Stock> stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    public MutualFund(String id, String name, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean checkIfStockExists(String stockName){
        return this.stocks.contains(new Stock(stockName));
    }

    public List<Stock> addStock(String stockName){
        List<Stock> modifiedStocksList = this.getStocks();
        modifiedStocksList.add(new Stock(stockName));
        return modifiedStocksList;
    }


}
