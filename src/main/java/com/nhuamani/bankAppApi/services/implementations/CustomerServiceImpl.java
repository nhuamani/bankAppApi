package com.nhuamani.bankAppApi.services.implementations;

import com.nhuamani.bankAppApi.models.Customer;
import com.nhuamani.bankAppApi.repositories.CustomerRepository;
import com.nhuamani.bankAppApi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateById(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }
}
