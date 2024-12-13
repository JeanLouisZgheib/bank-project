package com.business.bank.controllers;

import com.business.bank.DTO.AccountRequestDTO;
import com.business.bank.DTO.AccountResponseDTO;
import com.business.bank.models.Account;
import com.business.bank.services.AccountService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;
    ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("create-account")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody @Valid AccountRequestDTO accountRequestDTO) throws Exception {
        Account account = modelMapper.map(accountRequestDTO, Account.class);
        Account createAccount = accountService.createAccount(account);
        AccountResponseDTO accountResponseDTO = modelMapper.map(createAccount, AccountResponseDTO.class );
        accountResponseDTO.setAccountHolderId(createAccount.getAccountHolder().getId());
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update-account/{accountId}")
    public void updateAccount(@RequestBody Account account, @PathVariable UUID accountId) throws Exception {
        accountService.updateAccount(account, accountId);
    }

    @PatchMapping("/patch-account/{accountId}/{balance}")
    public ResponseEntity<Float> patchAccount(@PathVariable UUID accountId, @PathVariable Float balance) throws Exception {
        Float newBalance = accountService.modifyBalance(accountId, balance);
        return new ResponseEntity<>(newBalance, HttpStatus.ACCEPTED);
    }
}
