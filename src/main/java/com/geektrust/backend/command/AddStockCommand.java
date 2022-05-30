package com.geektrust.backend.command;

import com.geektrust.backend.service.IMutualFundService;
import com.geektrust.backend.util.CommandConstants;

import java.util.List;

public class AddStockCommand implements ICommand{

    IMutualFundService mutualFundService;

    public AddStockCommand(IMutualFundService mutualFundService){
        this.mutualFundService = mutualFundService;
    }
    @Override
    public void execute(List<String> input) {

        if(input!=null && input.size() >= (CommandConstants.STOCK_NAME_START_POS+1)){
            String fundName = input.get(CommandConstants.ADD_STOCK_FUND_POS);
            StringBuilder stockName = new StringBuilder();
            for(int i =CommandConstants.STOCK_NAME_START_POS;i<input.size();i++){
                stockName.append(input.get(i)).append(" ");
            }
            stockName = new StringBuilder(stockName.toString().trim());
            try{
                mutualFundService.addStock(fundName, stockName.toString());
            }catch (Exception e){
                System.out.print(e.getMessage()+"\n");
            }
        }

    }
}
