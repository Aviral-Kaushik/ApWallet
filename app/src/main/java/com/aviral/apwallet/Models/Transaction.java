package com.aviral.apwallet.Models;

public class Transaction {

    private final String transaction;

    private final String transactionNumber;

    private final String transactionAmount;

    private final String transactionType;

    public Transaction(String transaction,
                       String transactionNumber,
                       String transactionAmount,
                       String transactionAmountColor) {
        this.transaction = transaction;
        this.transactionNumber = transactionNumber;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionAmountColor;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionAmountColor() {
        return transactionType;
    }
}
