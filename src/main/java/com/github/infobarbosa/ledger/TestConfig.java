package com.github.infobarbosa.ledger;

import java.util.Arrays;
import java.util.UUID;

import com.github.infobarbosa.ledger.Transaction.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private TransactionRepository transactionRepository;

  @Override
  public void run(String... args) throws Exception {
    final UUID ACCOUNT_ID = UUID.randomUUID();
    final Double DEBIT_AMOUNT = Double.valueOf(201L);
    final Double CREDIT_AMOUNT = Double.valueOf(199L);
    final String CREDIT_DESCRIPTION = "Credito em conta-corrente";
    final String DEBIT_DESCRIPTION = "Debito em conta-corrente";

    Transaction credit = new Transaction.Builder()
            .setAccountId( ACCOUNT_ID )
            .setDescription( CREDIT_DESCRIPTION )
            .setEntryAmount( CREDIT_AMOUNT )
            .setType( Type.CREDIT )
            .build();

    Transaction debit = new Transaction.Builder()
            .setAccountId( ACCOUNT_ID )
            .setDescription( DEBIT_DESCRIPTION )
            .setEntryAmount( DEBIT_AMOUNT )
            .setType( Type.DEBIT )
            .build();
    
    transactionRepository.saveAll(Arrays.asList(credit, debit));
  }
}