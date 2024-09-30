package com.nhuamani.bankAppApi.controllers;

import com.nhuamani.bankAppApi.exceptions.ModelNotFoundException;
import com.nhuamani.bankAppApi.models.Customer;
import com.nhuamani.bankAppApi.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customer = new ArrayList<>();
        customer = customerService.getAll();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getByIdCustomer(@PathVariable("id") UUID id){
        Customer customer = customerService.getById(id).orElseThrow(() -> new ModelNotFoundException("Customer no encontrado $id"));
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        customerService.create(customer);
        return new ResponseEntity<Customer>(HttpStatus.CREATED);
    }
}
