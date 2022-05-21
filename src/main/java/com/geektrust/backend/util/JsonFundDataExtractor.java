package com.geektrust.backend.util;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.entity.Stock;
import com.geektrust.backend.repository.IMutualFundRepo;
import com.geektrust.backend.repository.IStockRepo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonFundDataExtractor implements IFundDataExtractor {

    private final IStockRepo stockRepo;
    private final IMutualFundRepo mutualFundRepo;

    public JsonFundDataExtractor(IStockRepo stockRepo,IMutualFundRepo mutualFundRepo){
        this.stockRepo = stockRepo;
        this.mutualFundRepo = mutualFundRepo;
    }
    @Override
    public void extract() {

        JSONObject stockDataObj = new JSONObject(MutualFundConstants.stockData);
        JSONArray funds = stockDataObj.getJSONArray("funds");

        for(int i = 0 ; i< funds.length();i++){
            JSONObject fund = funds.getJSONObject(i);
            String fundName = fund.getString("name");
            JSONArray stockArr = fund.getJSONArray("stocks");
            List<Stock> stocks = new ArrayList<>();
            for(int j = 0; j < stockArr.length();j++){
                Stock stock = new Stock(stockArr.getString(j));
                stocks.add(stockRepo.save(stock));
            }
            MutualFund mutualfund = new MutualFund(fundName,stocks);
            mutualFundRepo.save(mutualfund);
        }
    }
}
