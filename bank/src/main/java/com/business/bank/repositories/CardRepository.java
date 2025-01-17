package com.business.bank.repositories;

import com.business.bank.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

    Card findByCvv(String cvv);

}
