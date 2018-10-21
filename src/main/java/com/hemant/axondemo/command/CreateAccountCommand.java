package com.hemant.axondemo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private String name;

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

    public CreateAccountCommand(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }
}
