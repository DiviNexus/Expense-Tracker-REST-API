package com.divija.expensetracker.mapper;

import com.divija.expensetracker.dto.ExpenseDTO;
import com.divija.expensetracker.entity.Expense;

public class ExpenseMapper {
    // Converting Expense entity object to ExpenseDTO
    public static ExpenseDTO toDTO(Expense expense) {   

        return new ExpenseDTO(
            expense.getId(),
            expense.getTitle(),
            expense.getAmount(),
            expense.getCategory(),
            expense.getDate(),
            expense.getDescription()
        );
    }

    // Converting ExpenseDTO ---> Expense, so that it will be saved in the DB.
    public static Expense toEntity(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();

        expense.setId(expenseDTO.getId());
        expense.setTitle(expenseDTO.getTitle());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDate(expenseDTO.getDate());
        expense.setDescription(expenseDTO.getDescription());

        return expense;
    }
}
