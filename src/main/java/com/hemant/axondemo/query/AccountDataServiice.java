package com.hemant.axondemo.query;

import com.hemant.axondemo.AccountView;
import com.hemant.axondemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountDataServiice {

    AccountRepository accountRepository;

    @Autowired
    public AccountDataServiice(AccountRepository accountRepository){
        this.accountRepository =accountRepository;
    }

    public AccountView getAccountById(String accountId){
        return this.accountRepository.getOne(accountId);
    }

    public List<AccountView> getAllAccounts(){
        return this.accountRepository.findAll();
    }
}
