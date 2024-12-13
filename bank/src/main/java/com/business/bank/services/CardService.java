package com.business.bank.services;

import com.business.bank.models.Card;
import com.business.bank.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard() {
        Card card = new Card();
        card.setExpiryDate(LocalDate.now().plusDays(1));
        card.setCvv(String.valueOf(new Random().nextInt(999)+100));
        card.setCardNumber(generateCardNumber());
        return cardRepository.save(card);
    }

    public String generateCardNumber() {
        String bin = "12345678";
        Random random = new Random();
        StringBuilder randomDigits = new StringBuilder();
        for (int i =0 ; i<8 ; i++) randomDigits.append(random.nextInt(10));
        return bin + randomDigits;
    }

    public Card findCardByCvv(String cvv) {
        Card card = cardRepository.findByCvv(cvv);
        return card;
    }

}
