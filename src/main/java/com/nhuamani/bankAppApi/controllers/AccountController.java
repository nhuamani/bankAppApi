package com.nhuamani.bankAppApi.controllers;

import com.nhuamani.bankAppApi.exceptions.ModelNotFoundException;
import com.nhuamani.bankAppApi.models.Account;
import com.nhuamani.bankAppApi.models.Customer;
import com.nhuamani.bankAppApi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
