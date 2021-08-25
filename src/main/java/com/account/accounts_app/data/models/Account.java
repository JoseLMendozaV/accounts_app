package com.account.accounts_app.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String accountClientName;
    private Integer accountNumber;
    private double accountBalance;
    private Integer accountState;

    public Account(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountClientName +
                ", accountNumber='" + accountNumber +
                ", accountBalance='" + accountBalance +
                ", accountState='" + accountState +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountClientName, accountNumber, accountBalance, accountState);
    }

}