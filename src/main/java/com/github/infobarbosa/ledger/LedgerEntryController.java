package com.github.infobarbosa.ledger;

import com.github.infobarbosa.ledger.LedgerEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LedgerEntryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LedgerEntryController.class);

    @RequestMapping("/ledgerentry")
    public LedgerEntry ledgerentry() {

        final UUID ACCOUNT_ID = UUID.randomUUID();
        final Double DEBIT_AMOUNT = Double.valueOf(201L);
        final Double CREDIT_AMOUNT = Double.valueOf(199L);
        final Double ACCOUNT_BALANCE = Double.valueOf(199L);
        final String CREDIT_DESCRIPTION = "Credito em conta-corrente";
        final String DEBIT_DESCRIPTION = "Debito em conta-corrente";

        LedgerEntry credit = new LedgerEntry.Builder()
                .setAccountId( ACCOUNT_ID )
                .setDescription( CREDIT_DESCRIPTION )
                .setEntryAmount( CREDIT_AMOUNT )
                .build();

        LOGGER.debug( credit.toString() );
        return credit;
    }
}
