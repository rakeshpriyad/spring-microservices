package com.test.bank.branch.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.test.bank.branch.model.Account;
import com.test.bank.branch.model.Customer;
import com.test.bank.branch.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 */
@RequestMapping("/customer")
@RestController
@Timed("petclinic.owner")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
//	Logger log = LoggerFactory.getLogger(OwnerResource.class);

    /**
     * Create Customer
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Read single Customer
     */
    @GetMapping(value = "/{customerId}")
    public Optional<Customer> findCustomer(@PathVariable("customerId") int customerId) {
        return customerRepository.findById(customerId);
    }

    /**
     * Read List of Customers
     */
    @GetMapping(value = "/all")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Update Customer
     */
    @PutMapping(value = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") int customerId, @Valid @RequestBody CustomerRequest ownerRequest) {
        final Optional<Customer> customer = customerRepository.findById(customerId);
       for(Account account:  customer.get().getAccount()) {
           System.out.println(account.getAccountNo());
       }
        final Customer customerModel = customer.orElseThrow(() -> new ResourceNotFoundException("Customer "+customerId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        customerModel.setFirstName(ownerRequest.getFirstName());
        customerModel.setLastName(ownerRequest.getLastName());
        customerModel.setCity(ownerRequest.getCity());
        customerModel.setAddress(ownerRequest.getAddress());
        customerModel.setTelephone(ownerRequest.getTelephone());
        log.info("Saving owner {}", customerModel);
        customerRepository.save(customerModel);
    }
}
