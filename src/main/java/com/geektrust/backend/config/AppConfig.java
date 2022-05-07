package com.geektrust.backend.config;

import com.geektrust.backend.command.AddFundsCommand;
import com.geektrust.backend.command.AddStockCommand;
import com.geektrust.backend.command.CalculateOverLapCommand;
import com.geektrust.backend.command.CommandInvoker;
import com.geektrust.backend.repository.IInvestorRepo;
import com.geektrust.backend.repository.IMutualFundRepo;
import com.geektrust.backend.repository.InvestorRepo;
import com.geektrust.backend.repository.MutualFundRepo;
import com.geektrust.backend.service.IInvestorService;
import com.geektrust.backend.service.IMutualFundService;
import com.geektrust.backend.service.InvestorService;
import com.geektrust.backend.service.MutualFundService;

public class AppConfig {
    private final IMutualFundRepo mutualFundRepo = new MutualFundRepo();
    private final IMutualFundService mutualFundService = new MutualFundService(mutualFundRepo);

    private final IInvestorRepo investorRepo = new InvestorRepo();
    private final IInvestorService investorService = new InvestorService(investorRepo,mutualFundService);

    private final  AddFundsCommand addFunds = new AddFundsCommand(investorService);
    private final AddStockCommand addStock = new AddStockCommand(mutualFundService);
    private final CalculateOverLapCommand calculateOverlap = new CalculateOverLapCommand(investorService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public AppConfig(){
        /**
         * initialising the available funds and creating an investor
        * */
        mutualFundService.loadFunds();
        investorService.create();

    }
    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CURRENT_PORTFOLIO",addFunds);
        commandInvoker.register("ADD_STOCK",addStock);
        commandInvoker.register("CALCULATE_OVERLAP",calculateOverlap);
        return commandInvoker;
    }

}
