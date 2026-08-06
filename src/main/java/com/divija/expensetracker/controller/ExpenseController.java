package com.divija.expensetracker.controller;

import org.springframework.web.bind.annotation.RestController;
import com.divija.expensetracker.service.ExpenseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping ;

import com.divija.expensetracker.entity.Expense;
import java.util.List;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.divija.expensetracker.dto.ExpenseDTO;
import com.divija.expensetracker.mapper.ExpenseMapper;

@RestController // Tells spring: this handles HTTP requests.
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Controller --> Service --> Repository --> Hibernate --> MySQL.
    @PostMapping("/expenses")   //POST
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        /* Java understands objects, not JSON. So Spring Boot has to convert this JSON into java object. 
           Who tells Spring to do that conversion?
                           👉 @RequestBody                */

        // converting/Mapping that expenseDTO from the client into an Entity, so the service layer can talk to it.
        Expense expense = ExpenseMapper.toEntity(expenseDTO); 
        Expense savedExpense = expenseService.saveExpense(expense); //Saving the expense entity.  
        ExpenseDTO savedExpenseDTO = ExpenseMapper.toDTO(savedExpense);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedExpenseDTO);
    }

    @GetMapping("/expenses")    //GET ALL
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        
        List<Expense> expenses = expenseService.getAllExpenses();

        List<ExpenseDTO> expenseDTOs = expenses.stream() // stream : take this list & create a stream of its elts, moving one by one.
                .map(ExpenseMapper::toDTO)  //map: transform each elt into smth else; Expense --> ExpenseDTO . "::" is called Method Reference. Expense1 --> ExpenseMapper.toDTO(expense1),...
                // the elt count remains same after map, but the elts are modified or transformed.
                .toList();  // Collect all the converted objects back into a list.

        return ResponseEntity.ok(expenseDTOs);
    }

    @GetMapping("/expenses/{id}") // GET by ID
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense); //ok :- expense object found, send it with 200 OK HTTP response.
    }

    @GetMapping("/expenses/category/{category}") // GET BY Category
    public ResponseEntity<List<ExpenseDTO>> getExpensesByCategory(@PathVariable String category) {   // Based on the category you provide in the URL, @PathVariable will take it.

        List<Expense> expenses = expenseService.getExpensesByCategory(category);

        List<ExpenseDTO> expenseDTOs = expenses.stream()
                .map(ExpenseMapper::toDTO)
                .toList();

        return ResponseEntity.ok(expenseDTOs);
    }

    @GetMapping("/expenses/title/{title}") // GET by TITLE
    public ResponseEntity<List<ExpenseDTO>> getExpensesByTitle(@PathVariable String title) {

        List<Expense> expenses = expenseService.getExpensesByTitle(title);

        List<ExpenseDTO> expenseDTOs = expenses.stream()
                .map(ExpenseMapper::toDTO)
                .toList(); 
                    
        return ResponseEntity.ok(expenseDTOs);
    }

    @GetMapping("/expenses/date/{date}") // GET by DATE
    public ResponseEntity<List<ExpenseDTO>> getExpensesByDate(@PathVariable LocalDate date) {

        List<Expense> expenses = expenseService.getExpensesByDate(date);

        List<ExpenseDTO> expenseDTOs = expenses.stream()
                .map(ExpenseMapper::toDTO)
                .toList();
        
        return ResponseEntity.ok(expenseDTOs);
    }

    @PutMapping("/expenses/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDTO updatedExpenseDTO) {
        //First, convert the DTO into an Entity for the Service Layer.
        Expense expense = ExpenseMapper.toEntity(updatedExpenseDTO);
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        // Converting it back to DTO as promised to the Client, since the client shouldn't know about Entity Expense.
        ExpenseDTO responseDTO = ExpenseMapper.toDTO(updatedExpense); 
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}


