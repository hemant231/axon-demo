package com.hemant.axondemo.api;

import com.hemant.axondemo.AccountView;
import com.hemant.axondemo.query.AccountDataServiice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountQueryController {
    private static final Logger log = LoggerFactory.getLogger(AccountQueryController.class);

    private final AccountDataServiice accountDataService;

    @Autowired
    public AccountQueryController(AccountDataServiice accountDataService) {
        this.accountDataService = accountDataService;
    }

    @GetMapping("/account/{accountId}")
    public AccountView getAccountById(@PathVariable String accountId) {
        log.info("Request Account with id: {}", accountId);

        return accountDataService.getAccountById(accountId);
    }

    @GetMapping("/accounts")
    public List<AccountView> getAllAccounts() {
        log.info("Request all Accounts");

       return accountDataService.getAllAccounts();
    }
}
