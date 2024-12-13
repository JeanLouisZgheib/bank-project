package com.business.bank.controllers;

import com.business.bank.models.AccountHolder;
import com.business.bank.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @Autowired
    public AccountHolderController(final AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @PostMapping("create-account-holder")
    public ResponseEntity<AccountHolder> createAccountHolder(@RequestBody AccountHolder accountHolder) {
        AccountHolder createdAccountHolder = accountHolderService.createAccountHolder(accountHolder);
        return new ResponseEntity<>(createdAccountHolder, HttpStatus.CREATED);
//        return ResponseEntity.ok(createdAccountHolder);
    }


}
