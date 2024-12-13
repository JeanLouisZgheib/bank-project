package com.business.bank.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.UUID;

@Entity
@Table(name = "account_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class AccountCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_card_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;


}
