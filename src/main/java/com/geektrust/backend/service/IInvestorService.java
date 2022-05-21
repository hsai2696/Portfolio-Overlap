package com.geektrust.backend.service;


import java.util.List;

public interface IInvestorService {

    void create();

    /**
     * add funds to the investors funds list
     */
    void addFunds(String investorId, List<String> funds);
    /**
     * To get the overlap between two mutual funds
     */
    void getOverLap(String investorId,String newFund);

}
