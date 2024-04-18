package com.example.ICICI.Bank.BusinessException;


import java.io.Serial;

public class AccountCanNotBeTheSame extends Exception {
    @Serial
    private static final long serialVersionUID = -5517706112976904134L;


    private String errorcode;
    private String errormsg;

    public AccountCanNotBeTheSame(String errorcode, String errormsg) {
        this.errorcode = errorcode;
        this.errormsg = errormsg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
