package com.divija.expensetracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// This entire thing below is a Java Bean!!!

@Entity //This tells Spring Boot & Hibernate that this class represents data that should be stored in the DB.
public class Expense {
    @Id     // To make id the PRIMARY KEY (UNIQUE IDENTITY for the Expenses).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //Use Long over int because JPA entities use Wrapper classes (objects) like Long so they can be "null" before persistence (before stored in DB).

    // Other things an Expense should include (data object model designing) :-

    @NotBlank   //Title shouldn't be left Blank.....
    private String title;

    @Positive   //Amount should always be Positive. Negative amounts and 0/- are invalid!
    private Double amount;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String description;

    // No-argument Constructor
    public Expense(){

    }

    // Parameterized Constructor
    public Expense(String title, Double amount, String category, LocalDate date, String description){
        /* f we included "id" in the constructor, we'd be asking the caller to provide something that
         the database is already responsible for generating. */
    
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getter and Setter Methods, to achieve Encapsulation.
        public Long getId(){
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title = title;
        }

        public Double getAmount(){
            return amount;
        }
        public void setAmount(Double amount){
            this.amount = amount;
        }

        public String getCategory(){
            return category;
        }
        public void setCategory(String category){
            this.category = category;
        }

        public LocalDate getDate(){
            return date;
        }
        public void setDate(LocalDate date){
            this.date = date;
        }

        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description = description;
        }
}
