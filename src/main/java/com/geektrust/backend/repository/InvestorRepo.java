package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.exception.InvestorNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class InvestorRepo implements IInvestorRepo{
    private Map<String,Investor> investorData;

    public InvestorRepo(){
        investorData = new HashMap<>();
    }
    @Override
    public Investor save(Investor investor) {
        investorData.put(investor.getId(), investor);
        return investor;
    }

    @Override
    public Investor getByID(String id) {
        Investor investor=null;
        if(investorData!=null){
            investor = investorData.get(id);
        }
        if(investor==null){
            throw new InvestorNotFoundException("Kindly Initialize investor");
        }
        return investor;
    }
}
