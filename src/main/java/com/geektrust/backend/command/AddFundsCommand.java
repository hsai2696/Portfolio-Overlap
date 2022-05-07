package com.geektrust.backend.command;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.service.IInvestorService;
import com.geektrust.backend.util.InvestorConstants;

import java.util.List;

public class AddFundsCommand implements ICommand{

    IInvestorService investorService;
    public AddFundsCommand(IInvestorService investorService){
        this.investorService = investorService;
    }
    @Override
    public void execute(List<String> input) {
        if(input!=null && input.size() >=2){
            investorService.addFunds(input.subList(1,input.size()));
        }

    }
}
