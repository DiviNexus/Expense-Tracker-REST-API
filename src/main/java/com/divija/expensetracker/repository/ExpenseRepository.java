package com.divija.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divija.expensetracker.entity.Expense;
import java.util.List;
import java.time.LocalDate;



//probably the shortest class in the entire project!
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{   // Interface describes what can be done, not how it's done.
    //Search by Category
    List<Expense> findByCategory(String category);

    //Search by Title
    List<Expense> findByTitle(String title);

    //Search by Date
    List<Expense> findByDate(LocalDate date);



}
