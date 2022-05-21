package com.geektrust.backend.command;

import com.geektrust.backend.service.IInvestorService;
import com.geektrust.backend.util.CommandConstants;
import com.geektrust.backend.util.InvestorConstants;

import java.util.List;

public class AddFundsCommand implements ICommand{

    IInvestorService investorService;
    public AddFundsCommand(IInvestorService investorService){
        this.investorService = investorService;
    }
    @Override
    public void execute(List<String> input) {
        if(input!=null && input.size() >= CommandConstants.ADD_FUND_MIN_SIZE){
            investorService.addFunds(InvestorConstants.investorId,input.subList(1,input.size()));
        }

    }
}
