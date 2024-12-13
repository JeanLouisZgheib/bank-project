package com.business.bank.DTO;

import com.business.bank.models.AccountHolder;
import com.business.bank.models.Card;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class AccountResponseDTO {

    private UUID id;
    private Float balance;
    private String status;

    private UUID accountHolderId;
}
