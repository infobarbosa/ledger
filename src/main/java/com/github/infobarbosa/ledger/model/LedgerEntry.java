package com.github.infobarbosa.ledger.model;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public abstract class LedgerEntry {
    private final UUID accountId;
    private final Timestamp timestamp;
    private final UUID entryId;
    private final Double accountBalance;
    private final String description;

    protected LedgerEntry(Builder<? extends Builder> builder)
    {
        this.entryId = UUID.randomUUID();
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.accountId = builder.accountId;
        this.accountBalance = builder.accountBalance;
        this.description = builder.description;
    }


    public abstract static class Builder<T extends Builder<T>>{
        private UUID accountId;
        private Double entryAmount;
        private Double accountBalance;
        private String description;

        public T setAccountId(UUID accountId) {
            this.accountId = accountId;
            return (T) this;
        }

        public T setEntryAmount(Double entryAmount) {
            this.entryAmount = entryAmount;
            return (T) this;
        }

        public T setAccountBalance(Double accountBalance) {
            this.accountBalance = accountBalance;
            return (T) this;
        }

        public T setDescription(String description) {
            this.description = description;
            return (T) this;
        }

        public abstract LedgerEntry build();

        protected abstract T self();
    }

    //Getters
    public UUID getEntryId() {
        return entryId;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public UUID getAccountId() {
        return accountId;
    }
    public Double getAccountBalance() { return accountBalance; }
    public String getDescription() { return description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedgerEntry that = (LedgerEntry) o;
        return Objects.equals(entryId, that.entryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId);
    }

    @Override
    public String toString() {
        return "LedgerEntry{" +
                "accountId=" + accountId +
                ", timestamp=" + timestamp +
                ", entryId=" + entryId +
                ", accountBalance=" + accountBalance +
                ", description='" + description + '\'' +
                '}';
    }
}
