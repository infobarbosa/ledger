package com.github.infobarbosa.ledger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.github.infobarbosa.ledger.model.Credit;
import com.github.infobarbosa.ledger.model.Debit;
import com.github.infobarbosa.ledger.model.LedgerEntry.Builder;
import com.github.infobarbosa.ledger.model.LedgerEntry;
import com.github.infobarbosa.ledger.repository.CassandraConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.UUID;

public class LedgerApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(LedgerApp.class);

    private static final int LOOP_INTERACTIONS = 100000;


    public static void main(String[] args) {

        final UUID ACCOUNT_ID = UUID.randomUUID();
        final Double DEBIT_AMOUNT = Double.valueOf(201L);
        final Double CREDIT_AMOUNT = Double.valueOf(199L);
        final Double ACCOUNT_BALANCE = Double.valueOf(199L);
        final String CREDIT_DESCRIPTION = "Credito em conta-corrente";
        final String DEBIT_DESCRIPTION = "Debito em conta-corrente";

//        LedgerEntry ledgerEntry = new LedgerEntry.Builder().build();

        Credit credit = new Credit.Builder()
                .setAccountId( ACCOUNT_ID )
                .setDescription( CREDIT_DESCRIPTION )
                .setAccountBalance( ACCOUNT_BALANCE )
                .setCreditAmount( CREDIT_AMOUNT )
                .build();

        System.out.println( credit );

        Debit debit = new Debit.Builder()
                .setDebitAmount( DEBIT_AMOUNT )
                .setAccountBalance( ACCOUNT_BALANCE )
                .setAccountId( ACCOUNT_ID )
                .setDescription( DEBIT_DESCRIPTION )
                .build();

        System.out.println( debit );

//        LedgerEntry ledgerEntry = LedgerEntry.newEntry(ACCOUNT_ID, ORIGIN_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT, ACCOUNT_BALANCE, DESCRIPTION);

//        Session session = CassandraConnection.getSession();
//        PreparedStatement prepared = session.prepare(
//                     "insert into ledger (" +
//                        "   transaction_account_id,\n" +
//                        "   transaction_timestamp,\n" +
//                        "   transaction_id,\n" +
//                        "   transaction_origin_account_id,\n" +
//                        "   transaction_debit_amount,\n" +
//                        "   transaction_credit_amount,\n" +
//                        "   transaction_account_balance,\n" +
//                        "   transaction_description) values (?,?,?,?,?,?,?,?)")
//                    .setConsistencyLevel(ConsistencyLevel.QUORUM);
//
//        BoundStatement bound = prepared.bind(
//                ledgerEntry.getAccountId(),
//                ledgerEntry.getTimestamp(),
//                ledgerEntry.getEntryId(),
//                ledgerEntry.getOriginAccountId(),
//                ledgerEntry.getDebitAmount(),
//                ledgerEntry.getCreditAmount(),
//                ledgerEntry.getAccountBalance(),
//                ledgerEntry.getDescription());
//
//        session.execute(bound);
    }
}
