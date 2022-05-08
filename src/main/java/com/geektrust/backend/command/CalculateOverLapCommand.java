package com.geektrust.backend.command;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.exception.InvestorNotFoundException;
import com.geektrust.backend.service.IInvestorService;
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
                investorService.getOverLap(input.get(1));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
}
