package com.geektrust.backend.entity;

import java.util.List;

public class MutualFund {

    String id;
    String name;
    List<String> stocks;


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

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStocks() {
        return stocks;
    }

    public void setStocks(List<String> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "MutualFund{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
