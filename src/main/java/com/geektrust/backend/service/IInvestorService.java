package com.geektrust.backend.service;


import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.exception.MutualFundNotFoundException;

import java.util.List;

public interface IInvestorService {

    public Investor create();

    public  Investor getByID(String id);

    /**
     * add funds to the investors funds list
     */
    public Investor addFunds(List<String> funds);
    /**
     * To get the overlap between two mutual funds
     */
    public void getOverLap(String newFund);

}
