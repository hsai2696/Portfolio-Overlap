package com.geektrust.backend.service;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.repository.IInvestorRepo;
import com.geektrust.backend.util.InvestorConstants;

import java.util.List;
import java.util.stream.Collectors;

public class InvestorService implements  IInvestorService{

    private final IInvestorRepo investorRepo;
    private final IMutualFundService mutualFundService;

    public InvestorService(IInvestorRepo investorRepo,IMutualFundService mutualFundService){
        this.investorRepo = investorRepo;
        this.mutualFundService = mutualFundService;
    }


    @Override
    public void create() {
        Investor investor = new Investor(InvestorConstants.investorId);
        investorRepo.save(investor);
    }

    @Override
    public void addFunds(String investorId, List<String> funds) {
        Investor investor = investorRepo.getByID(investorId);

        investor.setFunds(funds.stream()
                .map((fundName) -> mutualFundService.getFundByName(fundName))
                .collect(Collectors.toList()));

        investorRepo.save(investor);
    }

    @Override
    public void getOverLap(String investorId,String newFund) {
        Investor investor = investorRepo.getByID(investorId);
        MutualFund overlapFund = mutualFundService.getFundByName(newFund);
        investor.getFunds().stream()
                .forEach((portfolioFund)->{
            String overlappingPercentage = mutualFundService.getOverLap(portfolioFund, overlapFund);
            if (Double.parseDouble(overlappingPercentage) > 0)
                System.out.print(newFund + " " + portfolioFund.getName() + " " + overlappingPercentage + "%\n");
        });

    }
}
