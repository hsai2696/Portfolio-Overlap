package com.geektrust.backend.repository;

import com.geektrust.backend.entity.MutualFund;

import java.util.List;
import java.util.Map;

public interface IMutualFundRepo {
    public MutualFund save(MutualFund mutualFund);
    public MutualFund getById(String id);

    public List<MutualFund> getAll();
}
