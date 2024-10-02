package com.nhuamani.bankAppApi.services.implementations;

import com.nhuamani.bankAppApi.models.Account;
import com.nhuamani.bankAppApi.repositories.AccountRepository;
import com.nhuamani.bankAppApi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Optional<Account> getById(UUID id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateById(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(UUID id) {
        accountRepository.deleteById(id);
    }
}
