package com.nhuamani.bankAppApi.services;

import com.nhuamani.bankAppApi.models.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    public List<Customer> getAll();
    public Optional<Customer> getById(UUID id);
    public Customer create(Customer customer);
    public Customer updateById(Customer customer);
    public void deleteById(UUID id);
}
