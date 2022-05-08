package com.geektrust.backend.command;

import com.geektrust.backend.service.IMutualFundService;
import com.geektrust.backend.util.MutualFundConstants;

import java.util.List;

public class AddStockCommand implements ICommand{

    IMutualFundService mutualFundService;

    public AddStockCommand(IMutualFundService mutualFundService){
        this.mutualFundService = mutualFundService;
    }
    @Override
    public void execute(List<String> input) {

        if(input!=null && input.size() >= (MutualFundConstants.STOCK_NAME_START_POS+1)){
            String fundName = input.get(1);
            String stockName ="";
            for(int i =MutualFundConstants.STOCK_NAME_START_POS;i<input.size();i++){
                stockName+=input.get(i)+" ";
            }
            stockName = stockName.trim();
            try{
                mutualFundService.addStock(fundName,stockName);
            }catch (Exception e){
                System.out.print(e.getMessage()+"\n");
            }
        }

    }
}
