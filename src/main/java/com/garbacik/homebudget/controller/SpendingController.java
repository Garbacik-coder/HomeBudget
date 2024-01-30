package com.garbacik.homebudget.controller;

import com.garbacik.homebudget.model.Spending;
import com.garbacik.homebudget.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SpendingController {
    @Autowired
    private SpendingService spendingService;

    @PostMapping("/spending")
    public Spending add(@RequestBody Spending spending){
        return spendingService.saveSpending(spending);
    }

    @GetMapping("/spendings")
    public List<Spending> list(){
        return spendingService.getAllSpendings();
    }

    @GetMapping("/spending/{id}")
    public Spending getSpendingById(@PathVariable(value = "id") Integer id){
        return spendingService.getSpendingById(id);
    }

    @PutMapping("/spending")
    public Spending updateSpending(@RequestBody Spending spending){
        return spendingService.updateSpending(spending);
    }

    @DeleteMapping("/spending/{id}")
    public void deleteSpendingById(@PathVariable(value = "id") Integer id){
        spendingService.deleteSpendingById(id);
    }
}
