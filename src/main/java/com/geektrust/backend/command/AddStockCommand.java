package com.geektrust.backend.command;

import com.geektrust.backend.service.IMutualFundService;
import java.util.List;

public class AddStockCommand implements ICommand{

    IMutualFundService mutualFundService;

    public AddStockCommand(IMutualFundService mutualFundService){
        this.mutualFundService = mutualFundService;
    }
    @Override
    public void execute(List<String> input) {

        if(input!=null && input.size()==3){
            String fundName = input.get(1);
            String stockName = input.get(2);
            try{
                mutualFundService.addStock(fundName,stockName);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
