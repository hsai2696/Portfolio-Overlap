package com.geektrust.backend.service;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.exception.MutualFundNotFoundException;

public interface IMutualFundService {
    MutualFund getFundByName(String name) throws MutualFundNotFoundException;
    String getOverLap(MutualFund existing, MutualFund present);
    MutualFund addStock(String fundName,String stockName) throws MutualFundNotFoundException;
}
