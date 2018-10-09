package com.github.infobarbosa.ledger.model;

public class Debit extends LedgerEntry {
    private Double debitAmount;

    private Debit(Builder builder) {
        super(builder);
        this.debitAmount = builder.debitAmount;
    }

    public static class Builder extends LedgerEntry.Builder<Builder>{
        private Double debitAmount;

        @Override public Debit build(){
            return new Debit(this);
        }

        @Override protected Builder self(){ return this; }

        public Builder setDebitAmount(Double debitAmount){
            this.debitAmount = debitAmount;
            return this;
        }
    }

    public Double getDebitAmount(){
        return this.debitAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Debit{" +
                "debitAmount=" + debitAmount +
                '}';
    }
}
