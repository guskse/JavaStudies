package org.example.service;

import org.example.model.Expense;
import org.example.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImplDB implements ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepository;


    //GET BY DAY
    @Override
    public List<Expense> getExpenseByDay(String date) {
        return expenseRepository.findAll().stream().filter(expense -> expense.getDate().equalsIgnoreCase(date)).toList();
    }

    //GET BY CATEGORY AND MONTH
    @Override
    public List<Expense> getExpenseByCategoryAndMonth(String category, String month) {
        return expenseRepository.findAll().stream().filter(expense -> expense.getCategory().equalsIgnoreCase(category) && expense.getDate().startsWith(month)).toList();
    }

    //GET ALL CATEGORIES
    @Override
    public List<String> getAllExpenseCategories() {
        return expenseRepository.findAll().stream().map(Expense::getCategory).distinct().toList();
    }


    //GET EXPENSE BY ID
    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    //POST A NEW EXPENSE
    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    //PUT EXPENSE
    @Override
    public boolean updateExpense(Expense updatedExpense) {
        if (expenseRepository.existsById(updatedExpense.getId())) {
            expenseRepository.save(updatedExpense);
            return true;
        }
        return false;
    }

    //DELETE EXPENSE
    @Override
    public boolean deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
