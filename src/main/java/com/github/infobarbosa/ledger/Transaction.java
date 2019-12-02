package com.github.infobarbosa.ledger;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public Transaction(){}
    
    public enum Type {
		CREDIT,
		DEBIT,
	}

    @Id
    private UUID id;
    private UUID accountId;
    private Timestamp timestamp;
    private Double amount;
    private String description;
    private Type type;

    protected Transaction(UUID accountId, Double amount, String description, Type type)
    {
        this.id = UUID.randomUUID();
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }


    public static class Builder {
        private UUID accountId;
        private Double amount;
        private String description;
        private Type type;

        public Builder(){}

        public Builder setAccountId(UUID accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setEntryAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setType(Type type){
            this.type = type;
            return this;
        }

        public Transaction build(){
            return new Transaction(this.accountId, this.amount, this.description, this.type);
        };
    }

    //Getters
    public UUID getId() { return id; }
    public Timestamp getTimestamp() { return timestamp; }
    public UUID getAccountId() { return accountId; }
    public Double getAmount() { return amount; }
    public String getDescription() { return description; }
    public Type getType(){ return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "LedgerEntry{" +
                "accountId=" + accountId +
                ", timestamp=" + timestamp +
                ", id=" + id +
                ", entryAmount=" + amount +
                ", description=" + description + 
                ", type=" + type + 
                "}";
    }
}
