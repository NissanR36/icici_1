package com.example.ICICI.Bank.BusinessException;

import java.io.Serial;

public class ResorceNotFound extends Exception {
    @Serial
    private static final long serialVersionUID = -8944166557863619371L;

    private String errorcode;
    private String errormsg;

    public ResorceNotFound(String errorcode, String errormsg) {
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
