package com.nhuamani.bankAppApi.repositories;

import com.nhuamani.bankAppApi.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
