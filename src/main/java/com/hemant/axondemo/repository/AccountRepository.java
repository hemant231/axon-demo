package com.hemant.axondemo.repository;

import com.hemant.axondemo.entities.AccountView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountView, String> {

}
