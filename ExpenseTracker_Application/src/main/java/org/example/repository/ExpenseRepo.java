package org.example.repository;

import org.example.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//need to pass the class and the identifier type
//(Long because id is a Long datatype in this case) and Expense because it is an Expense data Repository
@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {}
