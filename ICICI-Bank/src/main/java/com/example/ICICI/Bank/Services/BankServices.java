package com.example.ICICI.Bank.Services;

import com.example.ICICI.Bank.BusinessException.AccountCanNotBeTheSame;
import com.example.ICICI.Bank.BusinessException.AccountDeosNotEixst;
import com.example.ICICI.Bank.BusinessException.LowBalanceException;
import com.example.ICICI.Bank.BusinessException.ResorceNotFound;
import com.example.ICICI.Bank.POJO.Loan;
import com.example.ICICI.Bank.POJO.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankServices {

    User Saveuser(User user) throws LowBalanceException;


    User searchuser(int accountno) throws ResorceNotFound;

    double wthdraw(int accountno,double withdrawamt);

    double deposit(int accountno, double depositoryamt) throws ResorceNotFound;

    double balancecheck(int accountno) throws AccountDeosNotEixst;

    String SendMoney(int senderaccountno, int reciveraccountno, double amt) throws AccountCanNotBeTheSame;

    Loan SearchLoan(int loanid);

    Loan loandetailsbyaccountno(int accountno);

    List<User> GetAll() throws ResorceNotFound;


}
