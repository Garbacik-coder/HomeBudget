package com.garbacik.homebudget.controller;

import com.garbacik.homebudget.model.Spending;
import com.garbacik.homebudget.service.SpendingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/spending")
@CrossOrigin
@Api(tags = "Home Budget API", description = "Essential controller for CRUD operations")
public class SpendingController {
    @Autowired
    private SpendingService spendingService;

    @ApiOperation(value = "Add spending")
    @PostMapping("/add")
    public Spending add(@RequestBody Spending spending){
        return spendingService.saveSpending(spending);
    }

    @ApiOperation(value = "Get list of all spendings")
    @GetMapping("/getAll")
    public List<Spending> list(){
        return spendingService.getAllSpendings();
    }

    @ApiOperation(value = "Get spending by Id")
    @GetMapping("/get/{id}")
    public Spending getSpendingById(@PathVariable(value = "id")
                                        @ApiParam(value = "ID of spending", required = true) Integer id){
        return spendingService.getSpendingById(id);
    }

    @ApiOperation(value = "Get spending by month and year")
    @GetMapping("/getByDate")
    public List<Spending> getSpendingByMonth(@RequestBody Date date){
        return spendingService.getSpendingByMonth(date);
    }

    @ApiOperation(value = "Update spending existing in database")
    @PutMapping("/update")
    public Spending updateSpending(@RequestBody Spending spending){
        return spendingService.updateSpending(spending);
    }

    @ApiOperation(value = "Delete spending by Id")
    @DeleteMapping("/delete/{id}")
    public void deleteSpendingById(@ApiParam(value = "ID of spending", required = true)
                                       @PathVariable(value = "id") Integer id){
        spendingService.deleteSpendingById(id);
    }
}
