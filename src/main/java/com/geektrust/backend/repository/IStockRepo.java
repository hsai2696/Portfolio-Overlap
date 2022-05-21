package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Investor;
import com.geektrust.backend.entity.Stock;

public interface IStockRepo {

    public Stock save(Stock stock);
    public Stock getByID(String id);
}
