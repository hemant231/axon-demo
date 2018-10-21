package com.hemant.axondemo.api;

import com.hemant.axondemo.entities.AccountStatement;
import com.hemant.axondemo.repository.AccountStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountStatementController {

    private AccountStatementRepository accountStatementRepository;

    @Autowired
    AccountStatementController(AccountStatementRepository accountStatementRepository){
        this.accountStatementRepository = accountStatementRepository;
    }

    @GetMapping("/accounts/{accountId}/statements")
    public List<AccountStatement> getAccountStatementForAccountId(@PathVariable String accountId){
        Assert.notNull(accountId,"Account id can not be null");
       return this.accountStatementRepository.findByAccountId(accountId);
    }
}
