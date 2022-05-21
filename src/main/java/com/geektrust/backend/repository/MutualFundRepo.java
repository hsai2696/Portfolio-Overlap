package com.geektrust.backend.repository;

import com.geektrust.backend.entity.MutualFund;

import java.util.*;

public class MutualFundRepo implements IMutualFundRepo{

    private int autoIncrement = 0;
    private Map<String, MutualFund> mutualFundData;
    public MutualFundRepo(){
        this.mutualFundData = new HashMap<>();
    }

    public MutualFund save(MutualFund mutualFund){
        MutualFund resultant;
        if(mutualFund.getId()==null){
            MutualFund newFund = new MutualFund(Integer.toString(autoIncrement++),mutualFund.getName(),mutualFund.getStocks());
            mutualFundData.put(newFund.getId(), newFund);
            resultant = newFund;
        }else{
            mutualFundData.put(mutualFund.getId(), mutualFund);
            resultant = mutualFund;
        }
        return  resultant;
    }

    @Override
    public Optional<List<MutualFund>> getAll() {

        List<MutualFund> funds = new ArrayList<>();
        for (MutualFund mutualFund : mutualFundData.values()) {
            funds.add(mutualFund);
        }
        return Optional.of(funds);
    }
}
