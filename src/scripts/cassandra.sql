create keyspace ledger WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

create table ledger.ledger_entries(
    entry_id UUID,
    account_balance double,
    account_id UUID,
    credit_amount double,
    debit_amount double,
    description text,
    original_account_id UUID,
    entry_timestamp timestamp,
    primary key( entry_id )
);
