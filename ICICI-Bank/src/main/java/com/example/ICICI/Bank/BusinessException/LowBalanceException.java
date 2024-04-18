package com.example.ICICI.Bank.BusinessException;

import java.io.Serial;

public class LowBalanceException extends Exception {

    @Serial
    private static final long serialVersionUID = -5479947895602695097L;
    private String errorcode;
    private String errormessage;

    public LowBalanceException(String s, String balanceIsLow) {
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
