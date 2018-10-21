package com.hemant.axondemo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "account")
@Table(name = "account")
public class AccountView {

    @Id
    private String accountId;
    private String name;
    private double balance;

    public AccountView(String accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

        static class Builder{
        private String accountId ;
        private String name;
        private double balance;

            public void setAccountId(String accountId) {
                this.accountId = accountId;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setBalance(double balance) {
                this.balance = balance;
            }

            public AccountView build(){
                return new AccountView(accountId, name, balance);
            }
        }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static Builder accountBuilder(){return new Builder();}

    public AccountView(){

    }
}
