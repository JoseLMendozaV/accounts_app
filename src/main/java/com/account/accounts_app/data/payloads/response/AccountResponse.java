package com.account.accounts_app.data.payloads.response;

public class AccountResponse {

    private String message;

    public AccountResponse(String message) {
        this.message = message;
    }
    public void setAccount(String message) {
        this.message = message;
    }
    public String getAccount() {
        return message;
    }
}
