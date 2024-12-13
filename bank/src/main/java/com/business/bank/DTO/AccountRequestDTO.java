package com.business.bank.DTO;

import com.business.bank.models.AccountHolder;
import com.business.bank.models.Card;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class AccountRequestDTO {

    @NotNull(message = "Balance cannot be null")
    @Positive(message = "balance must be positive")
    private Float balance;

    @NotBlank(message = "status cannot be blank")
    private String status;

    private AccountHolder accountHolder;
}
