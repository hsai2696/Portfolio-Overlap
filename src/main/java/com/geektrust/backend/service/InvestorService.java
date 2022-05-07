package com.geektrust.backend.service;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.repository.IInvestorRepo;
import com.geektrust.backend.util.InvestorConstants;

import java.util.List;

public class InvestorService implements  IInvestorService{

    IInvestorRepo investorRepo;
    IMutualFundService mutualFundService;

    public InvestorService(IInvestorRepo investorRepo,IMutualFundService mutualFundService){
        this.investorRepo = investorRepo;
        this.mutualFundService = mutualFundService;
    }


    @Override
    public Investor create() {
        Investor investor = new Investor(InvestorConstants.investorId);
        return investorRepo.save(investor);
    }

    @Override
    public Investor getByID(String id) {
        return investorRepo.getByID(id);
    }

    @Override
    public Investor addFunds(List<String> funds) {
        Investor investor = getByID(InvestorConstants.investorId);
        investor.setFunds(funds);
        return investorRepo.save(investor);
    }

    @Override
    public void getOverLap(String newFund) {
        Investor investor = getByID(InvestorConstants.investorId);
        List<String> fundIds = investor.getFunds();
        for(int i = 0; i < fundIds.size(); i++){
            MutualFund existing = mutualFundService.getFundByName(fundIds.get(i));
            MutualFund present = mutualFundService.getFundByName(newFund);
            System.out.println(newFund+" "+existing.getName()+" "+mutualFundService.getOverLap(existing,present)+"%");
        }
    }
}
