package com.geektrust.backend.repository;

import com.geektrust.backend.entity.Investor;

public interface IInvestorRepo {
    public Investor save(Investor investor);
    public Investor getByID(String id);
}
