package com.shubin.model.store;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int computerId;
    private int userId;
    private int amount;
    private Date created;

    public Transaction() {
    }

    public Transaction(int computerId, int userId, int amount) {
        this.computerId = computerId;
        this.userId = userId;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
