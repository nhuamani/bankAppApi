package com.nhuamani.bankAppApi.controllers;

import com.nhuamani.bankAppApi.exceptions.ModelNotFoundException;
import com.nhuamani.bankAppApi.models.Account;
import com.nhuamani.bankAppApi.models.enums.EType;
import com.nhuamani.bankAppApi.services.AccountService;
import com.nhuamani.bankAppApi.utils.GenerateAccountNumber;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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
        String accountNumber = GenerateAccountNumber.accountNumber();
        account.setAccountNumber(accountNumber);
        account.setBalance(0);
        accountService.create(account);
        return new ResponseEntity<Account>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable("id") UUID id, @Valid @RequestBody Account account) {
        Account dbaccount = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));
        dbaccount.setAccountNumber(account.getAccountNumber());
        dbaccount.setAccountType(account.getAccountType());
        dbaccount.setStatus(account.getStatus());
        dbaccount.setBalance(0);
        dbaccount.setCustomerId(account.getCustomerId());
        return accountService.updateById(dbaccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable UUID id) {
        Account account = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));
        accountService.deleteById(account.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idAccount}/deposit")
    public Account depositToAccount(@PathVariable("idAccount") UUID id, @Valid @RequestBody Account account) {
        Account dbaccount = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));

        if(!dbaccount.getStatus()) throw new ModelNotFoundException("account is not active");

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double total = Double.parseDouble(decimalFormat.format(dbaccount.getBalance() + account.getBalance()));

        dbaccount.setAccountNumber(dbaccount.getAccountNumber());
        dbaccount.setAccountType(dbaccount.getAccountType());
        dbaccount.setStatus(dbaccount.getStatus());
        dbaccount.setBalance(total);
        dbaccount.setCustomerId(dbaccount.getCustomerId());
        return accountService.updateById(dbaccount);
    }

    @PutMapping("/{idAccount}/withdraw")
    public Account withdrawFromAccount(@PathVariable("idAccount") UUID id, @Valid @RequestBody Account account) {
        Account dbaccount = accountService.getById(id).orElseThrow(() -> new ModelNotFoundException("Account not found"));

        if(!dbaccount.getStatus()) throw new ModelNotFoundException("account is not active");

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if(dbaccount.getAccountType() == EType.AHORROS && dbaccount.getBalance() > 0 && dbaccount.getBalance() >= account.getBalance()) {
            double total = Double.parseDouble(decimalFormat.format(dbaccount.getBalance() - account.getBalance()));
            dbaccount.setBalance(total);
        } else if (dbaccount.getAccountType() == EType.CORRIENTE && dbaccount.getBalance() > -500) {
            double total = Double.parseDouble(decimalFormat.format(dbaccount.getBalance() - account.getBalance()));
            dbaccount.setBalance(total);
        } else {
            throw new ModelNotFoundException("Client does not have a checking or savings account");
        }

        dbaccount.setAccountNumber(dbaccount.getAccountNumber());
        dbaccount.setAccountType(dbaccount.getAccountType());
        dbaccount.setStatus(dbaccount.getStatus());
        dbaccount.setCustomerId(dbaccount.getCustomerId());

        return accountService.updateById(dbaccount);
    }
}
