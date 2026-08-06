package com.divija.expensetracker.service;

import org.springframework.stereotype.Service;

import com.divija.expensetracker.repository.ExpenseRepository;
import com.divija.expensetracker.entity.Expense;
import com.divija.expensetracker.exception.ExpenseNotFoundException;
import com.divija.expensetracker.exception.ExpenseNotFoundException;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

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

    // Get by CATEGORY
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    //GET by TITLE
    public List<Expense> getExpensesByTitle(String title) {
        return expenseRepository.findByTitle(title);
    }

    //GET by DATE
    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    // GET by ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
            .orElseThrow(() -> new ExpenseNotFoundException("Expense with ID " + id + " not found"));
            // Find the expense or else throw an exception!!!
    }

    // UPDATE
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense expense = expenseRepository.findById(id).orElseThrow();

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDate(updatedExpense.getDate());
        expense.setDescription(updatedExpense.getDescription());

        return expenseRepository.save(expense);
    }

    // DELETE
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}


