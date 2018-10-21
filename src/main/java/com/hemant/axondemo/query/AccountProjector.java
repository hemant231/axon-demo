package com.hemant.axondemo.query;

import com.hemant.axondemo.entities.AccountStatement;
import com.hemant.axondemo.entities.AccountView;
import com.hemant.axondemo.event.AccountCreatedEvent;
import com.hemant.axondemo.event.MoneyDepositedEvent;
import com.hemant.axondemo.event.MoneyWithdrawnEvent;
import com.hemant.axondemo.repository.AccountRepository;
import com.hemant.axondemo.repository.AccountStatementRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AccountProjector {

    private AccountRepository accountRepository;

    private AccountStatementRepository accountStatementRepository;

    @Autowired
    public AccountProjector(AccountRepository accountRepository,
                            AccountStatementRepository accountStatementRepository){
        this.accountRepository =accountRepository;
        this.accountStatementRepository = accountStatementRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent){
        AccountView accountView =
                new AccountView(accountCreatedEvent.getAccountId(), accountCreatedEvent.getName(), 0.0);
        accountRepository.save(accountView);

        accountStatementRepository
                .save(new AccountStatement(accountView.getAccountId(),
                        accountView.getBalance(),
                        0.0,
                        'N',
                        LocalDateTime.now()));
    }

    @EventHandler
    public void on(MoneyDepositedEvent moneyDepositedEvent){
        String accountId= moneyDepositedEvent.getAccountId();

        AccountView accountView = accountRepository.getOne(accountId);
        double newBalance =accountView.getBalance() + moneyDepositedEvent.getAmount();
                accountView.setBalance(moneyDepositedEvent.getAmount());

         accountView.setBalance(newBalance);
         accountRepository.save(accountView);

         accountStatementRepository
                 .save(new AccountStatement(accountView.getAccountId(),
                         accountView.getBalance(),
                         moneyDepositedEvent.getAmount(),
                         'C',
                         LocalDateTime.now()));
    }

    @EventHandler
    public void on(MoneyWithdrawnEvent moneyWithdrawnEvent){
        String accountId= moneyWithdrawnEvent.getAccountId();

        AccountView accountView = accountRepository.getOne(accountId);
        double newBalance =accountView.getBalance() - moneyWithdrawnEvent.getAmount();
        accountView.setBalance(moneyWithdrawnEvent.getAmount());

        accountView.setBalance(newBalance);
        accountRepository.save(accountView);

        accountStatementRepository
                .save(new AccountStatement(accountView.getAccountId(),
                        accountView.getBalance(),
                        moneyWithdrawnEvent.getAmount(),
                        'D',
                        LocalDateTime.now()));
    }

}
