package com.geektrust.backend.repository;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.exception.MutualFundNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MutualFundRepo implements IMutualFundRepo{

    private int autoIncrement = 0;
    private Map<String, MutualFund> mutualFundData;
    public MutualFundRepo(){
        this.mutualFundData = new HashMap<>();
    }

    public MutualFund save(MutualFund mutualFund){
        MutualFund resultant = null;
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
    public MutualFund getById(String id) {
        if(mutualFundData==null || mutualFundData.get(id)!=null){
            throw new MutualFundNotFoundException("FUND_NOT_FOUND");
        }
        return mutualFundData.get(id);
    }

    @Override
    public List<MutualFund> getAll() {
        if(mutualFundData==null){
           throw new MutualFundNotFoundException("FUND_NOT_FOUND");
        }
        return mutualFundData.values().stream().collect(Collectors.toList());
    }
}
