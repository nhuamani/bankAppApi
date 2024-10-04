package com.nhuamani.bankAppApi.services;

import com.nhuamani.bankAppApi.models.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {
    public List<Account> getAll();
    public Optional<Account> getById(UUID id);
    public Account create(Account account);
    public Account updateById(Account account);
    public void deleteById(UUID id);
    public Account depositById(Account account);
    public Account withdrawById(Account account);
}
