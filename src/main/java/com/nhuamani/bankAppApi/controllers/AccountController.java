package com.nhuamani.bankAppApi.controllers;

import com.nhuamani.bankAppApi.exceptions.ModelNotFoundException;
import com.nhuamani.bankAppApi.models.Account;
import com.nhuamani.bankAppApi.models.Customer;
import com.nhuamani.bankAppApi.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> account = new ArrayList<>();
        account = accountService.getAll();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getByIdAccount(@PathVariable("id") UUID id) {
        Account account = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found $id"));
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        accountService.create(account);
        return new ResponseEntity<Account>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable("id") UUID id, @Valid @RequestBody Account account) {
        Account dbaccount = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));
        dbaccount.setAccountNumber(account.getAccountNumber());
        dbaccount.setAccountType(account.getAccountType());
        dbaccount.setStatus(account.getStatus());
        dbaccount.setBalance(account.getBalance());
        dbaccount.setCustomerId(account.getCustomerId());
        return accountService.updateById(dbaccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable UUID id) {
        Account account = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));
        accountService.deleteById(account.getId());
        return ResponseEntity.noContent().build();
    }
}
