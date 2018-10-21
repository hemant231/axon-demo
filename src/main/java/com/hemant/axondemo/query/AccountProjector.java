package com.hemant.axondemo.query;

import com.hemant.axondemo.AccountView;
import com.hemant.axondemo.event.AccountCreatedEvent;
import com.hemant.axondemo.event.MoneyDepositedEvent;
import com.hemant.axondemo.event.MoneyWithdrawnEvent;
import com.hemant.axondemo.repository.AccountRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountProjector {

    private AccountRepository accountRepository;

    @Autowired
    public AccountProjector(AccountRepository accountRepository){
        this.accountRepository =accountRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent){
        AccountView accountView =
                new AccountView(accountCreatedEvent.getAccountId(), accountCreatedEvent.getName(), 0.0);
        accountRepository.save(accountView);
    }

    @EventHandler
    public void on(MoneyDepositedEvent moneyDepositedEvent){
        String accountId= moneyDepositedEvent.getAccountId();

        AccountView accountView = accountRepository.getOne(accountId);
        double newBalance =accountView.getBalance() + moneyDepositedEvent.getAmount();
                accountView.setBalance(moneyDepositedEvent.getAmount());

         accountView.setBalance(newBalance);
         accountRepository.save(accountView);
    }

    @EventHandler
    public void on(MoneyWithdrawnEvent moneyWithdrawnEvent){
        String accountId= moneyWithdrawnEvent.getAccountId();

        AccountView accountView = accountRepository.getOne(accountId);
        double newBalance =accountView.getBalance() - moneyWithdrawnEvent.getAmount();
        accountView.setBalance(moneyWithdrawnEvent.getAmount());

        accountView.setBalance(newBalance);
        accountRepository.save(accountView);
    }

}
