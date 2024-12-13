package com.business.bank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "account_holder")
@Getter
@Setter
@Audited
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_holder_id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "mother_name")
    private String motherName;

    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts = new ArrayList<>();


}
