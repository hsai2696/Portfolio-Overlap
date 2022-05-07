package com.geektrust.backend.service;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.exception.MutualFundNotFoundException;

public interface IMutualFundService {
    public void loadFunds();
    public MutualFund getFundByName(String name) throws MutualFundNotFoundException;
    public MutualFund getById(String id);
    public MutualFund create(MutualFund fund);
    public String getOverLap(MutualFund existing, MutualFund present);
    public MutualFund addStock(String fundName,String stockName) throws MutualFundNotFoundException;
}
