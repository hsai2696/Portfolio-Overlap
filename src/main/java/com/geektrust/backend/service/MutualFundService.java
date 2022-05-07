package com.geektrust.backend.service;

import com.geektrust.backend.entity.MutualFund;
import com.geektrust.backend.exception.MutualFundNotFoundException;
import com.geektrust.backend.repository.IMutualFundRepo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MutualFundService implements IMutualFundService{

    IMutualFundRepo mutualFundRepo;

    public MutualFundService(IMutualFundRepo mutualFundRepo){
        this.mutualFundRepo = mutualFundRepo;
    }

    @Override
    public void loadFunds() {
        StringBuffer stockData= new StringBuffer();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input"+ File.separator+"stock_data.json");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                stockData.append(sc.nextLine());
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

        JSONObject stockDataObj = new JSONObject(stockData.toString());

        JSONArray funds = stockDataObj.getJSONArray("funds");

        for(int i = 0 ; i< funds.length();i++){
            JSONObject fund = funds.getJSONObject(i);

            String fundName = (String)fund.get("name");
            JSONArray stockArr = fund.getJSONArray("stocks");
            List<String> stocks = new ArrayList<>();
            for(int j = 0; j < stockArr.length();j++){
                stocks.add(stockArr.getString(j));
            }
            MutualFund mutualfund = new MutualFund(fundName,stocks);
            create(mutualfund);
        }

    }

    @Override
    public MutualFund getFundByName(String name) throws MutualFundNotFoundException {
        return mutualFundRepo.getAll().stream()
                .filter((fund)->fund.getName().equals(name))
                .findAny()
                .orElseThrow(()->new MutualFundNotFoundException("FUND_NOT_FOUND"));
    }

    @Override
    public MutualFund getById(String id) {
        return mutualFundRepo.getById(id);
    }

    @Override
    public MutualFund create(MutualFund fund) {

        return mutualFundRepo.save(fund);
    }

    @Override
    public String getOverLap(MutualFund existing, MutualFund present) {
        List<String> newStocks = present.getStocks();
        List<String> existingStocks = existing.getStocks();
        int commonStocksCnt = 0;
        for(int i = 0 ; i<newStocks.size();i++){
            if(existingStocks.contains(newStocks.get(i))){
                commonStocksCnt++;
            }
        }
        int totalStocks = (newStocks.size()+existingStocks.size());
        double result = (double)(2.0*(commonStocksCnt)/(totalStocks)*100.0);
        return String.format("%.2f",Math.round(result*100.00)/100.00);
    }

    @Override
    public MutualFund addStock(String fundName, String stockName) throws MutualFundNotFoundException {
        MutualFund mutualFund = getFundByName(fundName);
        List<String> stocks = mutualFund.getStocks();
        if(!stocks.contains(stockName)){
            stocks.add(stockName);
        }
        mutualFund.setStocks(stocks);
        return mutualFundRepo.save(mutualFund);
    }
}