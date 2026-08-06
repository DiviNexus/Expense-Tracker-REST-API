package com.divija.expensetracker.exception;

public class ExpenseNotFoundException extends RuntimeException {
        // Runtime Excep's : Arithmetic, NullPointer, IlleglaArgument...etc

        public ExpenseNotFoundException(String message){
                super(message); // Calling the constructor of the Parent Class--> RuntimeException(message) stores the message.
        }
}
