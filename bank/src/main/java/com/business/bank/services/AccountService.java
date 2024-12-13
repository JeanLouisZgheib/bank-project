package com.business.bank.services;

import com.business.bank.models.Account;
import com.business.bank.models.AccountHolder;
import com.business.bank.repositories.AccountHolderRepository;
import com.business.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountHolderRepository accountHolderRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository, AccountHolderRepository accountHolderRepository) {
        this.accountRepository = accountRepository;
        this.accountHolderRepository = accountHolderRepository;
    }

    public Account createAccount(Account account) throws Exception {
        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(account.getAccountHolder().getId());
        if(accountHolder.isPresent()) {
            account.setAccountHolder(accountHolder.get()); //accountHolder.get() 3m njib l object accountHolder mn l container Optional
            return accountRepository.save(account);
        }
        else{
            throw new Exception();
        }
    }

    public Account updateAccount(Account account, UUID id) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            account.setId(id);
            return accountRepository.save(account);
        }
        else{
            throw new Exception();
        }
    }

    public void deleteById(UUID id) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            accountRepository.deleteById(id);
        }
        else{
            throw new Exception();
        }
    }

    public Float modifyBalance(UUID accountId, Float balance) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if(accountOptional.isPresent()) {
            accountOptional.get().setBalance(balance);
            accountRepository.save(accountOptional.get());
            return  accountOptional.get().getBalance();
        }
        else{
            throw new Exception();
        }
    }

}
