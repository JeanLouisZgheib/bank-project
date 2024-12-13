package com.business.bank.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private UUID id;

    @Column(name = "account_balance")
    private Float balance;

    @Column(name = "account_status")
    private String status;

    @ManyToOne
    @JoinColumn(name="account_holder_id")
    private AccountHolder accountHolder;

    @ManyToMany
    private Set<Card> cards = new HashSet<>();

}
