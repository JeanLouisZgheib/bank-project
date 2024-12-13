package com.business.bank.controllers;

import com.business.bank.DTO.CardResponseDTO;
import com.business.bank.DTO.FindByCvvDTO;
import com.business.bank.models.Card;
import com.business.bank.services.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    private final ModelMapper modelMapper;

    @Autowired
    public CardController(CardService cardService, ModelMapper modelMapper) {
        this.cardService = cardService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("create-card")
    public ResponseEntity<Card> createCard() {
        Card card = cardService.createCard();
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @GetMapping("/find-card-by-cvv")
    public ResponseEntity<CardResponseDTO> findCardByCvv(@RequestBody FindByCvvDTO findByCvvDTO) {
        Card card = cardService.findCardByCvv(findByCvvDTO.getCvv());
        CardResponseDTO cardResponseDTO = modelMapper.map(card, CardResponseDTO.class);
        return new ResponseEntity<>(cardResponseDTO, HttpStatus.OK);

    }

    // PathVariable with id's in the path but
    //

}
