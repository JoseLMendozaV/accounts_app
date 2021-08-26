package com.account.accounts_app.service;

import com.account.accounts_app.data.models.Account;
import com.account.accounts_app.data.payloads.request.AccountRequest;
import com.account.accounts_app.data.payloads.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface AccountService {
    AccountResponse CreateAccount(AccountRequest accountRequest);
    Optional<Account> updateAccount (Integer accountId, AccountRequest accountRequest);
    void deleteAccount (Integer accountId);
    Account getSingleAccount(Integer accountId);
    List<Account> getAllAccount();
}
