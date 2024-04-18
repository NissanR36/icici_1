package com.example.ICICI.Bank.Controller;

import com.example.ICICI.Bank.BusinessException.AccountCanNotBeTheSame;
import com.example.ICICI.Bank.BusinessException.AccountDeosNotEixst;
import com.example.ICICI.Bank.BusinessException.LowBalanceException;
import com.example.ICICI.Bank.BusinessException.ResorceNotFound;
import com.example.ICICI.Bank.POJO.Loan;
import com.example.ICICI.Bank.POJO.User;
import com.example.ICICI.Bank.Services.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankController {

    @Autowired
    BankServices bankServices;

    @RequestMapping(value = "/SaveUser",method = RequestMethod.POST,produces ="application/json")
    public User savedata(@RequestBody User user)throws LowBalanceException{
        User saved=bankServices.Saveuser(user);

        return saved;
    }

    @RequestMapping(value = "/SEARCH/{accountno}",method = RequestMethod.GET,produces = "application/json")
    public User Search(@PathVariable int accountno)throws ResorceNotFound
    {
        User userfound=bankServices.searchuser(accountno);
        return userfound;

    }

    @RequestMapping(value = "/Withdraw/{accountno}/{withdrawamt}", method = RequestMethod.GET,produces = "application/json")
    public double withdraw(@PathVariable int accountno,@PathVariable double withdrawamt)
    {
        double balance=bankServices.wthdraw(accountno,withdrawamt);

        return balance;
    }

    @RequestMapping(value = "/Deposit/{accountno}/{depositoryamt}", method = RequestMethod.POST,produces = "application/json")
    public double deposit(@PathVariable int accountno,@PathVariable double depositoryamt) throws ResorceNotFound {
        double balance=bankServices.deposit(accountno,depositoryamt);

        return balance;
    }

    @RequestMapping(value = "/Balance Check/{accountno}",method = RequestMethod.GET,produces = "application/json")
    public  double balancecheck(@PathVariable int accountno) throws AccountDeosNotEixst {

        double balance=bankServices.balancecheck(accountno);

        return balance;

    }

    @RequestMapping(value = "/SEND MONEY/{senderaccountno}/{reciveraccountno}/{amt}",method = RequestMethod.POST,produces = "application/json")
    public String BalanceTranser(@PathVariable int senderaccountno, @PathVariable int reciveraccountno, @PathVariable double amt ) throws AccountCanNotBeTheSame {

        String Success=bankServices.SendMoney(senderaccountno,reciveraccountno,amt);
        return Success;
    }

    @RequestMapping(value = "/Search Loan/{loanid}",method = RequestMethod.GET,produces = "application/json")
    public Loan details(@PathVariable int loanid)
    {
        Loan user=bankServices.SearchLoan(loanid);
        return user;
    }

    @RequestMapping(value = "/Search Loan By Accountno/{accountno}",method = RequestMethod.GET,produces = "application/json")
    public Loan searchuserloanbyaccountno(@PathVariable int accountno)
    {
        Loan founddetails=bankServices.loandetailsbyaccountno(accountno);

        return founddetails;
    }

    @RequestMapping(value = "/AllUser",method = RequestMethod.GET,produces = "application/json")
    public List<User>alluser() throws ResorceNotFound {

        List<User>allusers=bankServices.GetAll();
        return  allusers;

    }


}
