package com.github.infobarbosa.ledger;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class LedgerEntry {
    private final UUID accountId;
    private final Timestamp timestamp;
    private final UUID entryId;
    private final Double entryAmount;
    private final String description;

    protected LedgerEntry(UUID accountId, Double entryAmount, String description)
    {
        this.entryId = UUID.randomUUID();
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.accountId = accountId;
        this.entryAmount = entryAmount;
        this.description = description;
    }


    public static class Builder {
        private UUID accountId;
        private Double entryAmount;
        private String description;

        public Builder(){}

        public Builder setAccountId(UUID accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setEntryAmount(Double entryAmount) {
            this.entryAmount = entryAmount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public LedgerEntry build(){
            return new LedgerEntry(this.accountId, this.entryAmount, this.description);
        };
    }

    //Getters
    public UUID getEntryId() { return entryId; }
    public Timestamp getTimestamp() { return timestamp; }
    public UUID getAccountId() { return accountId; }
    public Double getEntryAmount() { return entryAmount; }
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
                ", entryAmount=" + entryAmount +
                ", description='" + description + '\'' +
                '}';
    }
}
