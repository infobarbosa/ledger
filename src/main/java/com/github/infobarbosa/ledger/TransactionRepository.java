package com.github.infobarbosa.ledger;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{

}