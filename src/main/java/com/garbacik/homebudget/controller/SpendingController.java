package com.garbacik.homebudget.controller;

import com.garbacik.homebudget.model.Spending;
import com.garbacik.homebudget.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spending")
@CrossOrigin
public class SpendingController {
    @Autowired
    private SpendingService spendingService;

    @PostMapping("/add")
    public Spending add(@RequestBody Spending spending){
        return spendingService.saveSpending(spending);
    }

    @GetMapping("/getAll")
    public List<Spending> list(){
        return spendingService.getAllSpendings();
    }

    @GetMapping("/get/{id}")
    public Spending getSpendingById(@PathVariable(value = "id") Integer id){
        return spendingService.getSpendingById(id);
    }

    @PutMapping("/update")
    public Spending updateSpending(@RequestBody Spending spending){
        return spendingService.updateSpending(spending);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSpendingById(@PathVariable(value = "id") Integer id){
        spendingService.deleteSpendingById(id);
    }
}
