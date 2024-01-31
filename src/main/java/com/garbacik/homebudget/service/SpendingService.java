package com.garbacik.homebudget.service;

import com.garbacik.homebudget.model.Spending;

import java.util.Date;
import java.util.List;

public interface SpendingService {
    Spending saveSpending(Spending spending);
    List<Spending> getAllSpendings();

    Spending updateSpending(Spending spending);

    void deleteSpendingById(Integer id);

    Spending getSpendingById(Integer id);

    List<Spending> getSpendingByMonth(Date date);
}
