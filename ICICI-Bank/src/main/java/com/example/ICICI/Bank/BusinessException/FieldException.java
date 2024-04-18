package com.example.ICICI.Bank.BusinessException;

import java.io.Serial;


public class FieldException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 7949805115933375786L;
    @Serial
    private String errorcode;
    private String errormsg;

    public FieldException(String errorcode, String errormsg) {
        this.errorcode = errorcode;
        this.errormsg = errormsg;
    }

    public FieldException() {
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
