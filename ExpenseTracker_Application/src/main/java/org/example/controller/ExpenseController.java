package org.example.controller;

import org.example.model.Expense;
import org.example.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    //GET ALL CATEGORIES FROM EXPENSES
    @GetMapping("/expenses/categories")
    public ResponseEntity<List<String>> getAllExpenseCategories() {

        List<String> categories = expenseService.getAllExpenseCategories();

        //if categories is empty, return status no content and body null
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        //return list of categories with status of OK
        return ResponseEntity.ok(categories);
    }

    //GET EXPENSES BY DATE
    @GetMapping("/expenses/day/{date}")
    public ResponseEntity<List<Expense>> getExpensesByDay(@PathVariable("date") String date) {

        List<Expense> expenses = expenseService.getExpenseByDay(date);

        //if categories is empty, return status no content and body null
        if (expenses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        //return list of categories with status of OK
        return ResponseEntity.ok(expenses);
    }

    //GET EXPENSES BY CATEGORY AND MONTH
    @GetMapping("/expenses/categories/{category}/month")
    public ResponseEntity<List<Expense>> getExpensesByCategoryAndMonth(@PathVariable String category, @RequestParam String month) {

        List<Expense> expenses = expenseService.getExpenseByCategoryAndMonth(category, month);

        //if categories is empty, return status "no content" and body null
        if (expenses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        //return list of categories with status of OK
        return ResponseEntity.ok(expenses);

        //EXAMPLE OF GET REQUEST FOR THIS ROUTE
        //http://localhost:8080/expenses/categories/Meat/month?month=2024-09
    }

    //GET EXPENSE BY ID
    @GetMapping("/expenses/{id}")
    public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable Long id) {

        Optional<Expense> expense = expenseService.getExpenseById(id);

        //if categories is empty, return status "no content" and body null
        if (expense.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        //return list of categories with status of OK
        return ResponseEntity.ok(expense);
    }


    //CREATE NEW EXPENSE WITH POST
    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense newExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }


    //UPDATE EXPENSE WITH PUT
    @PutMapping("/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {

        updatedExpense.setId(id);

        //will return true or false
        boolean isUpdated = expenseService.updateExpense(updatedExpense);

        //if true, return the updated expense with status ok
        if (isUpdated) {
            return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
        }

        //if false, return not found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    //DELETE EXPENSE
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        boolean isDeleted = expenseService.deleteExpense(id);

        //if is successfully deleted, return http status no content
        if (isDeleted) {
            return new ResponseEntity<>("Deleted successfully!", HttpStatus.NO_CONTENT);
        }

        //if couldn't delete, return not found
        return new ResponseEntity<>("Could not delete", HttpStatus.NOT_FOUND);

    }


}
