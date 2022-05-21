package com.geektrust.backend.command;

import com.geektrust.backend.service.IInvestorService;
import com.geektrust.backend.util.CommandConstants;
import com.geektrust.backend.util.InvestorConstants;

import java.util.List;

public class CalculateOverLapCommand implements ICommand{

    IInvestorService investorService;

    public CalculateOverLapCommand(IInvestorService investorService){
        this.investorService = investorService;
    }

    @Override
    public void execute(List<String> input) {
            try{
                String fundToAdd = input.get(CommandConstants.GET_OVERLAP_FUND_POS);
                investorService.getOverLap(InvestorConstants.investorId,fundToAdd);
            }catch(Exception e){
                System.out.print(e.getMessage()+"\n");
            }
    }
}
