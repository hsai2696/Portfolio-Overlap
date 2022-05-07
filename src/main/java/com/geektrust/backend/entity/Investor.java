package com.geektrust.backend.entity;

import java.util.List;

public class Investor {
    String id;
    /**
     * List of the mutual fund ids that are owned by the investor
     */
    List<String> funds;


    public Investor(String id){
        this.id = id;
    }
    public Investor(String id, List<String> funds) {
        this.id = id;
        this.funds = funds;
    }

    public String getId(){
        return this.id;
    }

    public List<String> getFunds() {
        return funds;
    }

    public void setFunds(List<String> funds) {
        this.funds = funds;
    }
}
