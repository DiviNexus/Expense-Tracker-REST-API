package com.divija.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.divija.expensetracker.entity.Expense;


//probably the shortest class in the entire project!
public interface ExpenseRepository extends JpaRepository<Expense, Long>{   // Interface describes what can be done, not how it's done.
    



}
