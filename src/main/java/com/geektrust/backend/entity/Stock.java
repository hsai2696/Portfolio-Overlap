package com.geektrust.backend.entity;

public class Stock {
    private String id;
    private String name;
    public Stock(String name){
        this.name = name;
    }
    public Stock(String id, String name){
        this(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return name.equals(stock.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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
}
