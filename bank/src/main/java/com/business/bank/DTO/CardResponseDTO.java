package com.business.bank.DTO;

import com.business.bank.models.Account;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class CardResponseDTO {

    private UUID id;
    private String cardNumber;
    private LocalDate expiryDate;
    private String cvv;
}
