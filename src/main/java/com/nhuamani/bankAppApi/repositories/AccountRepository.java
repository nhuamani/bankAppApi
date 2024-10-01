package com.nhuamani.bankAppApi.repositories;

import com.nhuamani.bankAppApi.models.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {
}
