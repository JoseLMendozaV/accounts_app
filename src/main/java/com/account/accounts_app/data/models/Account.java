package com.account.accounts_app.data.models;


import org.hibernate.annotations.SQLDelete;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "account")
@SQLDelete(sql = "UPDATE `account_db`.`account` SET `account_state` = '1' WHERE (`id` = ?)")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String accountClientName;
    private Integer accountNumber;
    private double accountBalance;
    private Byte accountState = 0;

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