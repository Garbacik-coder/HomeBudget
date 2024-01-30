package com.garbacik.homebudget.service;

import com.garbacik.homebudget.model.Spending;
import com.garbacik.homebudget.repository.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpendingServiceImpl implements SpendingService {

    @Autowired
    private SpendingRepository spendingRepository;

    @Override
    public Spending saveSpending(Spending spending) {
        return spendingRepository.save(spending);
    }

    @Override
    public List<Spending> getAllSpendings() {
        return spendingRepository.findAll();
    }

    @Override
    public Spending updateSpending(Spending inputSpending) {
        Optional<Spending> spending = spendingRepository.findById(inputSpending.getId());
        Spending updatedSpending = spending.get();
        updatedSpending.setName(inputSpending.getName());
        updatedSpending.setValue(inputSpending.getValue());
        updatedSpending.setCategory(inputSpending.getCategory());
        return spendingRepository.save(updatedSpending);
    }

    @Override
    public void deleteSpendingById(Integer id) {
        spendingRepository.deleteById(id);
    }

    @Override
    public Spending getSpendingById(Integer id) {
        return spendingRepository.findById(id).get();
    }
}
