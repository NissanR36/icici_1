package com.example.ICICI.Bank.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvise {

    @ExceptionHandler(LowBalanceException.class)
    public ResponseEntity<String>handellowbalace(LowBalanceException lowBalanceException)
    {
        return new ResponseEntity<String>("5000 Minimum Balance Required to open Account ",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FieldException.class)
    public ResponseEntity<String>handelfielempty(FieldException fieldException)
    {
        return new ResponseEntity<String>("Input Fields Are Empty...",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResorceNotFound.class)
    public ResponseEntity<String>handelresourcenotfound(ResorceNotFound resorceNotFound)
    {
        return new ResponseEntity<String>("No such User is there",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountDeosNotEixst.class)
    public ResponseEntity<String>handelaccountdoesnotexist(AccountDeosNotEixst accountDeosNotEixst)
    {
        return new ResponseEntity<String>("Account Does not exist",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String>handelaccountsame(AccountCanNotBeTheSame accountCanNotBeTheSame)
    {
        return new ResponseEntity<String>("Both Accounts Are Same",HttpStatus.BAD_REQUEST);
    }

}
