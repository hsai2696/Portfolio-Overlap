package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Investor;

public interface IInvestorRepo {
    void save(Investor investor);
    Investor getByID(String id);
}
