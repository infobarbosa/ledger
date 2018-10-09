package com.github.infobarbosa.ledger.model;

public class Credit extends LedgerEntry {
    private Double creditAmount;

    private Credit(Builder builder) {
        super(builder);
        this.creditAmount = builder.creditAmount;
    }

    public static class Builder extends LedgerEntry.Builder<Builder>{
        private Double creditAmount;

        public Builder setCreditAmount(Double creditAmount){
            this.creditAmount = creditAmount;
            return this;
        }

        @Override public Credit build(){
            return new Credit(this);
        }

        @Override protected Builder self(){ return this; }

    }

    public Double getCreditAmount(){
        return this.creditAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Credit{" +
                "creditAmount=" + creditAmount +
                '}';
    }
}
