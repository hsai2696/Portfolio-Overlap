package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Stock;

import java.util.Optional;

public interface IStockRepo {

    Stock save(Stock stock);
    Stock getByID(String id);

    Optional<Stock> getByName(String stockName);
}
