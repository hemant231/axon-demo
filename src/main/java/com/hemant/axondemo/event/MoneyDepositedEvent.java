package com.hemant.axondemo.event;

import org.axonframework.commandhandling.model.AggregateIdentifier;

import java.util.UUID;

public class MoneyDepositedEvent {
    @AggregateIdentifier
    private String accountId;
    private double amount;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MoneyDepositedEvent(String accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }
}
