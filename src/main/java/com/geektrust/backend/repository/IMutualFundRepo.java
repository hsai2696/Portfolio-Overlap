package com.geektrust.backend.repository;

import com.geektrust.backend.entity.MutualFund;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IMutualFundRepo {
    public MutualFund save(MutualFund mutualFund);

    public Optional<List<MutualFund>> getAll();
}
