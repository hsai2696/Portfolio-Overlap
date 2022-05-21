package com.geektrust.backend.entity;

import java.util.List;

public class Investor {
    private final String id;
    /**
     * List of the mutual fund ids that are owned by the investor
     */
    private List<MutualFund> funds;


    public Investor(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public List<MutualFund> getFunds() {
        return funds;
    }

    public void setFunds(List<MutualFund> funds) {
        this.funds = funds;
    }
}
