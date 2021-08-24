package com.account.accounts_app.data.payloads.response;

public class AccountResponse {

    private String message;

    public AccountResponse(String message) {
        this.message = message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
