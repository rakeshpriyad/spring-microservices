package com.test.bank.branch.web;

import com.test.bank.branch.model.AccountRepository;
import com.test.bank.branch.service.AccountService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.test.bank.branch.model.Account;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 */
@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountController {

	//@Autowired
    //private AccountRepository accountRepository;

	private AccountService accountService;

	@Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    /**
     * Create Account
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.save.apply(account);
    }

    /**
     * Read single Account
     */
    @GetMapping(value = "/{accountId}")
    public Optional<Account> findAccount(@PathVariable("accountId") int accountId) {
        return accountService.findById.apply(accountId);
    }

    /**
     * Read List of Accounts
     */
    @GetMapping
    public List<Account> findAll() {
        Integer i =accountService.sum.apply(5,7);
        accountService.sayHelloMsg.accept("Rajesh");
        return accountService.findAll.get();
    }

    /**
     * Update Owner
     */
    @PutMapping(value = "/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable("accountId") int accountId, @Valid @RequestBody AccountRequest accountRequest) {
        final Optional<Account> account = accountService.findById.apply(accountId);

        final Account accountModel = account.orElseThrow(() -> new ResourceNotFoundException("Customer "+accountId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        accountModel.setAccountNo(accountRequest.getAccountNo());

        log.info("Saving Account {}", accountModel);
        accountService.save.apply(accountModel);
    }
}
