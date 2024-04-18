package com.example.ICICI.Bank.BusinessException;

import java.io.Serial;

public class AccountDeosNotEixst extends Exception{


    @Serial
    private static final long serialVersionUID = -1634012920399624726L;

    private String errorcode;
    private String erromsg;

    public AccountDeosNotEixst(String errorcode, String erromsg) {
        this.errorcode = errorcode;
        this.erromsg = erromsg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErromsg() {
        return erromsg;
    }

    public void setErromsg(String erromsg) {
        this.erromsg = erromsg;
    }
}
