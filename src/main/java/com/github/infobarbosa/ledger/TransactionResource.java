package com.github.infobarbosa.ledger;

import com.github.infobarbosa.ledger.Transaction;
import com.github.infobarbosa.ledger.Transaction.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionResource.class);

    @GetMapping
    public ResponseEntity<Transaction> getTransaction() {

        final UUID ACCOUNT_ID = UUID.randomUUID();
        final Double DEBIT_AMOUNT = Double.valueOf(201L);
        final Double CREDIT_AMOUNT = Double.valueOf(199L);
        final Double ACCOUNT_BALANCE = Double.valueOf(199L);
        final String CREDIT_DESCRIPTION = "Credito em conta-corrente";
        final String DEBIT_DESCRIPTION = "Debito em conta-corrente";

        Transaction credit = new Transaction.Builder()
                .setAccountId( ACCOUNT_ID )
                .setDescription( CREDIT_DESCRIPTION )
                .setEntryAmount( CREDIT_AMOUNT )
                .setType( Type.CREDIT )
                .build();

        LOGGER.info( credit.toString() );
        return ResponseEntity.ok().body(credit);
    }
}
