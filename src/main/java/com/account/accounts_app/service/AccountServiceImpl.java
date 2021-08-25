package com.account.accounts_app.service;

import com.account.accounts_app.data.models.Account;
import com.account.accounts_app.data.payloads.request.AccountRequest;
import com.account.accounts_app.data.payloads.response.AccountResponse;
import com.account.accounts_app.data.repository.AccountRepository;
import com.account.accounts_app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountResponse CreateAccount(AccountRequest accountRequest) {
        Account newAccount = new Account();
        newAccount.setAccountClientName(accountRequest.getAccountClientName());
        newAccount.setAccountNumber(accountRequest.getAccountNumber());
        newAccount.setAccountBalance(accountRequest.getAccountBalance());
        newAccount.setAccountState(accountRequest.getAccountState());
        accountRepository.save(newAccount);
        return new AccountResponse("New Account created!!");
    }

    @Override
    public Optional<Account> updateAccount(Integer accountId, AccountRequest accountRequest) throws ResourceNotFoundException{
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()){
            throw new ResourceNotFoundException("Account", "id", accountId);
        }
        else
            account.get().setAccountBalance(accountRequest.getAccountBalance());
            accountRepository.save(account.get());
            return account;
    }

    @Override
    public Account getSingleAccount(Integer accountId) throws ResourceNotFoundException {
        return accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Integer accountId) throws ResourceNotFoundException {
        if (accountRepository.getById(accountId).getId().equals(accountId)) {
            accountRepository.deleteById(accountId);
        }
        else throw new ResourceNotFoundException("Account", "id", accountId);
    }
}
