package com.hemant.axondemo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "account_statement")
@Entity(name = "account_statement")
public class AccountStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long txnId;
    private String accountId;
    private double balance;
    private double transactionAmt;
    private char txnType;
    private LocalDateTime transactionDate;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(double transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public char getTxnType() {
        return txnType;
    }

    public void setTxnType(char txnType) {
        this.txnType = txnType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public AccountStatement(String accountId, double balance, double transactionAmt, char txnType, LocalDateTime transactionDate) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactionAmt = transactionAmt;
        this.txnType = txnType;
        this.transactionDate = transactionDate;
    }

    public AccountStatement() {
    }
}
