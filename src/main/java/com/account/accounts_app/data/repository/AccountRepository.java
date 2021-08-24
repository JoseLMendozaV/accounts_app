package com.account.accounts_app.data.repository;

import com.account.accounts_app.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {
}
