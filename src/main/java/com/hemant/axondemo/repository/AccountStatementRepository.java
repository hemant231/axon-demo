package com.hemant.axondemo.repository;

import com.hemant.axondemo.entities.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long> {

    public List<AccountStatement> findByAccountId(String accountId);
}
