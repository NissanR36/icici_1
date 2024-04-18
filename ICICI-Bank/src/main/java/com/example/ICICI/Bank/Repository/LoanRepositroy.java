package com.example.ICICI.Bank.Repository;

import com.example.ICICI.Bank.POJO.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepositroy extends JpaRepository<Loan,Integer> {

    Loan findById(int loanid);
}
