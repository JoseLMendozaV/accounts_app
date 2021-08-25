package com.account.accounts_app.web;

import com.account.accounts_app.data.models.Account;
import com.account.accounts_app.data.payloads.request.AccountRequest;
import com.account.accounts_app.data.payloads.response.AccountResponse;
import com.account.accounts_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Account> getAccountById (@PathVariable("id") Integer id) {
        Account account = accountService.getSingleAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<AccountResponse> addAccount (@RequestBody AccountRequest account) {
        AccountResponse newAccount = accountService.CreateAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    public Optional<Account> updateAccount(@PathVariable Integer id, @RequestBody AccountRequest account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount (@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
