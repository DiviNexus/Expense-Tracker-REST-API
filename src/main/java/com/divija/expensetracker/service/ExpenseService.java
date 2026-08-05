package com.divija.expensetracker.service;

import org.springframework.stereotype.Service;

import com.divija.expensetracker.repository.ExpenseRepository;
import com.divija.expensetracker.entity.Expense;
import java.util.List;

@Service    // Contains Business Logic: Please create & manage an object (Spring Bean) of it.
public class ExpenseService {
    private final ExpenseRepository expenseRepository;    // final is used so that once this variable is assigned, it can never refer to another repository object.

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    // GET Request
    public List<Expense> getAllExpenses() { 
        // Use List Collection to get all the multiple expense objects stored in DB.
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

}


