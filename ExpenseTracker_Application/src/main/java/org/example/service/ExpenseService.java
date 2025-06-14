package org.example.service;

import org.example.model.Expense;

import java.util.List;
import java.util.Optional;


public interface ExpenseService {
    List<Expense> getExpenseByDay(String date);

    List<Expense> getExpenseByCategoryAndMonth(String category, String month);

    List<String> getAllExpenseCategories();

    //optional<expense> means it can return a null value or an Expense type data
    Optional<Expense> getExpenseById(Long id);


    Expense addExpense(Expense expense);

    boolean updateExpense(Expense expense);

    boolean deleteExpense(Long id);


}
