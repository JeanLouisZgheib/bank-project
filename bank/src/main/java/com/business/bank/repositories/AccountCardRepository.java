package com.business.bank.repositories;

import com.business.bank.models.AccountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AccountCardRepository extends JpaRepository<AccountCard, UUID> {
}
