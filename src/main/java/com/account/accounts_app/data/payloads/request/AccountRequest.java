package com.account.accounts_app.data.payloads.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AccountRequest {
    @NotBlank
    @NotNull
    private String accountClientName;
    @NotBlank
    @NotNull
    private Integer accountNumber;
    @NotBlank
    @NotNull
    private double accountBalance;
    @NotBlank
    @NotNull
    private Integer accountState;

    public String getAccountClientName() {
        return accountClientName;
    }
    public void setAccountClientName(String accountClientName) {
        this.accountClientName = accountClientName;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public Integer getAccountState() {
        return accountState;
    }
    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

}
