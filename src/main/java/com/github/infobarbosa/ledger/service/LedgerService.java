package com.github.infobarbosa.ledger.service;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.github.infobarbosa.ledger.model.Credit;
import com.github.infobarbosa.ledger.model.Debit;
import com.github.infobarbosa.ledger.repository.CassandraConnection;

import java.util.UUID;

public class LedgerService {
//    private static Session cassandraSession;
//
//    public LedgerService(){
//        cassandraSession = CassandraConnection.getSession();
//    }
//
//    public void makeACredit(UUID accountId, UUID originAccountId, Double creditAmount, Double accountBalance, String description){
//        Credit credit = Credit.newCredit(accountId, originAccountId, creditAmount, accountBalance, description);
//
//        PreparedStatement prepared = cassandraSession.prepare(
//                "insert into ledger (" +
//                        "   transaction_account_id,\n" +
//                        "   transaction_timestamp,\n" +
//                        "   transaction_id,\n" +
//                        "   transaction_origin_account_id,\n" +
//                        "   transaction_debit_amount,\n" +
//                        "   transaction_credit_amount,\n" +
//                        "   transaction_account_balance,\n" +
//                        "   transaction_description) values (?,?,?,?,?,?,?,?)")
//                .setConsistencyLevel(ConsistencyLevel.QUORUM);
//
//        BoundStatement bound = prepared.bind(
//                credit.getAccountId(),
//                credit.getTimestamp(),
//                credit.getEntryId(),
//                credit.getOriginAccountId(),
//                credit.getDebitAmount(),
//                credit.getCreditAmount(),
//                credit.getAccountBalance(),
//                credit.getDescription());
//
//        cassandraSession.execute(bound);
//
//        //TODO
//        //implementar um tratamento de erros decente.
//    }
//
//    public void makeADebit(UUID accountId, UUID originAccountId, Double debitAmount, Double accountBalance, String description){
//        Debit debit = Debit.newDebit(accountId, originAccountId, debitAmount, accountBalance, description);
//    }
}
