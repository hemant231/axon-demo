package com.hemant.axondemo.api;

import com.hemant.axondemo.AccountView;
import com.hemant.axondemo.aggregrate.Account;
import com.hemant.axondemo.command.CreateAccountCommand;
import com.hemant.axondemo.command.DepositMoneyCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final CommandGateway commandGateway;

    @Autowired
    public AccountController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/accounts")
    public CompletableFuture<Object> createBankAccount(@RequestBody AccountView accountView) {
        log.info("Request to create account for: {}", accountView.getName());

        Assert.notNull(accountView.getName(), "The name of the account holder should not be null");

        String accountId = UUID.randomUUID().toString();

        CreateAccountCommand createAccountCommand = new CreateAccountCommand(accountId, accountView.getName());

        return commandGateway.send(createAccountCommand);
    }

    @PutMapping("/accounts/{accountId}/deposit/{amount}")
    public CompletableFuture<Object> depositMoney(@PathVariable String accountId, @PathVariable Double amount) {
        log.info("Request to withdraw {} dollar from account {} ", amount, accountId);

        return commandGateway.send(new DepositMoneyCommand(accountId, amount));
    }

    @PutMapping("/accounts/{accountId}/withdraw/{amount}")
    public CompletableFuture<Object> withdrawMoney(@PathVariable String accountId, @PathVariable Double amount) {
        log.info("Request to withdraw {} dollar from account {} ", amount, accountId);

        return commandGateway.send(new DepositMoneyCommand(accountId, amount));
    }

}
