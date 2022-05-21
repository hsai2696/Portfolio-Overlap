package com.geektrust.backend.service;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.entity.Stock;
import com.geektrust.backend.exception.MutualFundNotFoundException;
import com.geektrust.backend.repository.IMutualFundRepo;
import com.geektrust.backend.repository.IStockRepo;
import com.geektrust.backend.util.MutualFundConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MutualFundService implements IMutualFundService{

    private final IMutualFundRepo mutualFundRepo;

    private final IStockRepo stockRepo;

    public MutualFundService(IMutualFundRepo mutualFundRepo,IStockRepo stockRepo){
        this.mutualFundRepo = mutualFundRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public MutualFund getFundByName(String name) throws MutualFundNotFoundException {
        return mutualFundRepo.getAll().stream()
                .filter((fund)->fund.getName().equals(name))
                .findAny()
                .orElseThrow(()->new MutualFundNotFoundException(MutualFundConstants.FUND_MISSING_MESSAGE));
    }

    @Override
    public String getOverLap(MutualFund existing, MutualFund present) {
        List<Stock> newStocks = present.getStocks();
        List<Stock> existingStocks = existing.getStocks();
        int commonStocksCnt = 0;
        for (Stock newStock : newStocks) {
            if (existingStocks.contains(newStock)) {
                commonStocksCnt++;
            }
        }
        return getFormattedOverlapPercentage(newStocks, existingStocks, commonStocksCnt);
    }

    private String getFormattedOverlapPercentage(List<Stock> newStocks, List<Stock> existingStocks, int commonStocksCnt) {
        int totalStocks = (newStocks.size()+ existingStocks.size());
        double result = MutualFundConstants.OVERLAP_FORMULA_NUMERATOR_MULTIPLIER* commonStocksCnt
                /(totalStocks)*MutualFundConstants.OVERLAP_FORMULA_DENOMINATOR_MULTIPLIER;
        return String.format("%.2f", Math.round(result
                * MutualFundConstants.TWO_DIGIT_ROUNDED_DECIMAL_MULTIPLIER)
                / MutualFundConstants.TWO_DIGIT_ROUNDED_DECIMAL_MULTIPLIER);
    }

    @Override
    public MutualFund addStock(String fundName, String stockName) throws MutualFundNotFoundException {
        MutualFund mutualFund = getFundByName(fundName);
        List<Stock> stocks = mutualFund.getStocks();
        Stock newStock = new Stock(stockName);
        if(!stocks.contains(newStock)){
            stocks.add(stockRepo.save(newStock));
        }
        mutualFund.setStocks(stocks);
        return mutualFundRepo.save(mutualFund);
    }
}
