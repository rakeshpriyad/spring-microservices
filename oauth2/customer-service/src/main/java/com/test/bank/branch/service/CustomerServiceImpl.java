package com.test.bank.branch.service;

import com.test.bank.branch.model.Customer;
import com.test.bank.branch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
//    @PreAuthorize("hasAuthority('COMPANY_READ') and hasAuthority('DEPARTMENT_READ')")
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Customer get(Integer id) {
        return customerRepository.getOne(id);
    }


    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }


    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Customer get(String name) {

        return customerRepository.findAll().stream().filter(x -> x.getFirstName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_CREATE')")
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_UPDATE')")
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE')")
    public void delete(Integer id) {
        Customer customer =customerRepository.getOne(id);
        if(customer!= null) {
            customerRepository.delete(customer);
        }
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE')")
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
