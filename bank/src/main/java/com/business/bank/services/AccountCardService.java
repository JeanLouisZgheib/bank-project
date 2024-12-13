package com.business.bank.services;


import com.business.bank.models.Account;
import com.business.bank.models.AccountCard;
import com.business.bank.models.Card;
import com.business.bank.repositories.AccountCardRepository;
import com.business.bank.repositories.AccountRepository;
import com.business.bank.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountCardService {

    private final AccountCardRepository accountCardRepository;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    @Autowired
    public AccountCardService(AccountCardRepository accountCardRepository, AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountCardRepository = accountCardRepository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    public UUID linkAccountToCard(UUID accountId, UUID cardId) throws Exception {
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Card> card = cardRepository.findById(cardId);
        if(account.isEmpty() || card.isEmpty()) throw new Exception();
        AccountCard accountCard = new AccountCard();
        accountCard.setAccount(account.get());
        accountCard.setCard(card.get());
        AccountCard savedAccountCard = accountCardRepository.save(accountCard);
        return savedAccountCard.getId();
    }


}
