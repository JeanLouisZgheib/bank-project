package com.business.bank.services;

import com.business.bank.models.AccountHolder;
import com.business.bank.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;

    @Autowired
    public AccountHolderService(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    public Optional<AccountHolder> getById(UUID id) {
        return accountHolderRepository.findById(id);
    }

    public void deleteById(UUID id) {
        accountHolderRepository.deleteById(id);
    }
}
