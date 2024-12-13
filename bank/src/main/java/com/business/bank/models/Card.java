package com.business.bank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private UUID id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_date")
    private LocalDate expiryDate;

    @Column(name = "card_cvv")
    private String cvv;

    @ManyToMany
    private Set<Account> accounts = new HashSet<>();


}
