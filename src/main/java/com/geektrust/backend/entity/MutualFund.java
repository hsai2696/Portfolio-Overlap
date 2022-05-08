package com.geektrust.backend.entity;

import java.util.List;

public class MutualFund {

    private String id;
    private String name;
    private List<String> stocks;


    public MutualFund(String name, List<String> stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    public MutualFund(String id, String name, List<String> stocks) {
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



    public List<String> getStocks() {
        return stocks;
    }

    public void setStocks(List<String> stocks) {
        this.stocks = stocks;
    }


}
