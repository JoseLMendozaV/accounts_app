package com.account.accounts_app.web;

import com.account.accounts_app.data.models.Account;
import com.account.accounts_app.data.payloads.request.AccountRequest;
import com.account.accounts_app.data.payloads.response.AccountResponse;
import com.account.accounts_app.service.AccountService;
import com.account.accounts_app.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class AccountController {
    @Autowired
    AccountService accountService;
    AccountServiceImpl accountServiceImpl;

    @GetMapping("")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById (@PathVariable("id") Integer id) {
        Account account = accountService.getSingleAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<AccountResponse> addAccount (@RequestBody AccountRequest account) {
        AccountResponse newAccount = accountService.CreateAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public Optional<Account> updateAccount(@PathVariable Integer id, @RequestBody AccountRequest account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountServiceImpl.deleteAccount(id);
    }

}
