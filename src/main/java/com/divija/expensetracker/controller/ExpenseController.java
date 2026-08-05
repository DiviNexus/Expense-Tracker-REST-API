package com.divija.expensetracker.controller;

import org.springframework.web.bind.annotation.RestController;
import com.divija.expensetracker.service.ExpenseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.divija.expensetracker.entity.Expense;
import java.util.List;

@RestController // Tells spring: this handles HTTP requests.
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Controller --> Service --> Repository --> Hibernate --> MySQL.
    @PostMapping("/expenses")   //POST
    public Expense addExpense(@RequestBody Expense expense) {
        /* Java understands objects, not JSON. So Spring Boot has to convert this JSON into java object. 
           Who tells Spring to do that conversion?
                           👉 @RequestBody                */
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/expenses")    //GET
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}


