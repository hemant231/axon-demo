package com.hemant.axondemo.repository;

import com.hemant.axondemo.AccountView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountView, String> {

}
