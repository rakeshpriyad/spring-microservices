package com.test.bank.branch.service;

import com.test.bank.branch.model.Account;
import com.test.bank.branch.model.AccountRepository;
import com.test.bank.branch.model.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    public Supplier<List<AccountType>> findAccountTypes = () -> accountRepository.findAccountTypes();
    public Supplier<List<Account>> findAll = () -> accountRepository.findAll();


    public Function<Integer,Optional<AccountType>> findAccountTypeById = (typeId) -> accountRepository.findAccountTypeById(typeId);
    public Function<Account,Account> save = (account) -> accountRepository.save(account);
    public Function<Integer,Optional<Account>> findById = (accountId) -> accountRepository.findById(accountId);
    public Runnable sayHello = () -> System.out.println("Hello");
    public Consumer<String> sayHelloMsg = (msg) -> System.out.println("Hello "+msg);

    public BiFunction<Integer,Integer,Integer> sum = (a, b) -> a+b;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

   /* public  Integer sum(Integer a,Integer b){
        return a+b;
    }*/
    public static int factorial(int n){
       /* int fact =1;
        for (int i =1; i<= n; i++){
            fact =fact*i;
        }
        return fact;*/
       //final int fact =1;
      // final AtomicInteger fact = new AtomicInteger(1);
        int fact [] ={1};
       List<Integer> iList= IntStream.rangeClosed(1,n).boxed().collect(Collectors.toList());
       iList.forEach(i -> {
          // fact.set(fact.get()*i);
           fact[0] = fact[0]*i;
       });
        return fact[0];
       //return IntStream.rangeClosed(1,n).reduce(1,(x,y) -> x*y);
    }

    /*public List<AccountType> findAccountTypes(){
        return accountRepository.findAccountTypes();
    }

    public Optional<AccountType> findAccountTypeById(int typeId){
        return accountRepository.findAccountTypeById(typeId);
    }*/

    /*public Account save(Account account) {
       return accountRepository.save(account);
    }*/

    /*public Optional<Account> findById(int accountId) {
        return accountRepository.findById(accountId);
    }*/

    /*public List<Account> findAll() {
        return accountRepository.findAll();
    }*/

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
