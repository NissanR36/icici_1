package com.example.ICICI.Bank.ServiceIMPL;

import com.example.ICICI.Bank.BusinessException.*;
import com.example.ICICI.Bank.POJO.Insurance;
import com.example.ICICI.Bank.POJO.Loan;
import com.example.ICICI.Bank.POJO.User;
import com.example.ICICI.Bank.Repository.InsuranceRepository;
import com.example.ICICI.Bank.Repository.LoanRepositroy;
import com.example.ICICI.Bank.Repository.UserRepository;
import com.example.ICICI.Bank.Services.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SIMPL implements BankServices {

    @Value("${spring.mail.username}") private String mailFrom;

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanRepositroy loanRepositroy;

    @Autowired
    InsuranceRepository insuranceRepository;
    @Override
    public User Saveuser(User user) throws LowBalanceException, FieldException {

        Insurance insurance=new Insurance();

        insurance.setInsuranceid(user.getInsurance().getInsuranceid());
        insurance.setType(user.getInsurance().getType());
        insurance.setInsuranceamt(user.getInsurance().getInsuranceamt());
        insuranceRepository.save(insurance);

        Loan loan=new Loan();
        loan.setLoanid(user.getLoan().getLoanid());
        loan.setAmt(user.getLoan().getAmt());
        loan.setLoantype(user.getLoan().getLoantype());
         loanRepositroy.save(loan);

         user.setAccountno(user.getAccountno());
         user.setName(user.getName());
         user.setAddress(user.getAddress());
         user.setLoan(user.getLoan());
         user.setBalance(user.getBalance());
         user.setLoan(loan);
         user.setInsurance(insurance);

        SimpleMailMessage mailMessage=new SimpleMailMessage();

        String msg="Dear "+""+user.getName() +"\n"+"Your Accouny no is  "+userRepository.findById(user.getAccountno())+"\n"
                + " You have Successfully Opened Your Account With ICICI Bank";

        mailMessage.setText(msg);
        mailMessage.setSubject("Welcome To The ICICI World");
        mailMessage.setFrom(mailFrom);
        mailMessage.setTo(user.getEmail());

        javaMailSender.send(mailMessage);


         try {
             if(user.getName().isBlank()||user.getAddress().isBlank()||user.getInsurance().getType().isBlank()||user.getLoan().getLoantype().isBlank())
             {
                 throw new FieldException("402","Input Fields Are Empty");
             }

         }catch (FieldException e)
         {
             throw new FieldException("401","Evey Thing Is Fine");
         }
         try {

             if(user.getBalance()<5000) {
                 throw new LowBalanceException("202","Low Balance");
             }

         }catch (LowBalanceException e)
         {
             throw new LowBalanceException("204","Granted");
         }

         userRepository.save(user);

        return user;
    }

    @Override
    public User searchuser(int accountno) throws ResorceNotFound {

        try {
            if(userRepository.findById(accountno)==null)
            {
                throw new ResorceNotFound("502","Account Not Found");
            }

        }catch (ResorceNotFound e)
        {
            throw new ResorceNotFound("504","Found");
        }
        return userRepository.findById(accountno);
    }

    @Override
    public double wthdraw(int accountno,double withdrawamt) {

        User user=new User();

         user=userRepository.findById(accountno);

        double totalbalance=user.getBalance()-withdrawamt;

        user.setBalance(totalbalance);

        userRepository.save(user);


        return totalbalance;
    }

    @Override
    public double deposit(int accountno, double depositoryamt) throws ResorceNotFound {

        User user=new User();



        user=userRepository.findById(accountno);

        try {

            if (userRepository.findById(accountno) == null) {

                throw new ResorceNotFound("404","Account number does not exist");

            }
        }catch (ResorceNotFound e)
        {
            throw new ResorceNotFound("406","account doest not exist");

        }


        double newbalace=user.getBalance()+depositoryamt;

        user.setBalance(newbalace);

        userRepository.save(user);

        return newbalace;
    }

    @Override
    public double balancecheck(int accountno) throws AccountDeosNotEixst {

        try {

            if (userRepository.findById(accountno) == null) {

                throw new AccountDeosNotEixst("404","Account does not exist");

            }
        }catch (AccountDeosNotEixst e)
        {
            throw new AccountDeosNotEixst("406","Account does not exist");
        }

        double balance=userRepository.findById(accountno).getBalance();

        return balance;
    }

    @Override
    public String SendMoney(int senderaccountno, int reciveraccountno, double amt) throws AccountCanNotBeTheSame {

        User user=new User();


         user=userRepository.findById(senderaccountno);

         try{
             if(userRepository.findById(senderaccountno).equals(userRepository.findById(reciveraccountno)))
             {
                 throw new AccountCanNotBeTheSame("604","Account Can Not Be The Same");
             }

         }catch (AccountCanNotBeTheSame e)
         {
             throw new AccountCanNotBeTheSame("606","Account Can Not Be The Same");
         }


        double newbalance=user.getBalance()-amt;

        user.setBalance(newbalance);

        user=userRepository.findById(reciveraccountno);

        double moneyrecived=user.getBalance()+amt;
        user.setBalance(moneyrecived);

        System.out.println(user.toString());


        userRepository.save(user);



        return "Transaction Complete";
    }

    @Override
    public Loan SearchLoan(int loanid) {


        return  loanRepositroy.findById(loanid);
    }

    @Override
    public Loan loandetailsbyaccountno(int accountno) {

        return userRepository.findById(accountno).getLoan();

    }

    @Override
    public List<User> GetAll() throws ResorceNotFound {

        try {
            if(userRepository.findAll().isEmpty())
            {
                throw new ResorceNotFound("","");
            }

        }catch (ResorceNotFound e)
        {
            throw new ResorceNotFound("506","Database Empty");
        }


        return userRepository.findAll();
    }



}
