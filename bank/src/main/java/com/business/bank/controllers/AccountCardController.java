package com.business.bank.controllers;

import com.business.bank.services.AccountCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account-card")
public class AccountCardController {

    AccountCardService accountCardService;

    @Autowired
    public AccountCardController(AccountCardService accountCardService) {
        this.accountCardService = accountCardService;
    }

    @PostMapping("link-account-card/{accountId}/{cardId}")
    public ResponseEntity<UUID> linkAccountCard(@PathVariable UUID accountId, @PathVariable UUID cardId)throws Exception {
        UUID accountCardId = accountCardService.linkAccountToCard(accountId, cardId);
        return new ResponseEntity<>(accountCardId, HttpStatus.CREATED);
    }
}
