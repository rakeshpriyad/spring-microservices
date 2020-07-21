package com.test.bank.branch.service;

import com.test.bank.branch.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer get(Integer id);
    Optional<Customer> findById(Integer id);

    Customer get(String name);

    List<Customer> getAll();

    Customer create(Customer customer);

    Customer update(Customer customer);

    void delete(Integer id);

    void delete(Customer customer);
}
