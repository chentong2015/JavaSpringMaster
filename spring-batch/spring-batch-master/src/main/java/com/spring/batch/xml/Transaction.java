package com.spring.batch.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@SuppressWarnings("restriction")
@XmlRootElement(name = "transactionRecord")
public class Transaction {

    private String username;
    private int userId;
    private LocalDateTime transactionDate;
    private double amount;

    public Transaction() {
    }

    public Transaction(String username, int userId, LocalDateTime transactionDate, double amount) {
        this.username = username;
        this.userId = userId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction [username=" + username + ", userId=" + userId
                + ", transactionDate=" + transactionDate + ", amount=" + amount
                + "]";
    }
}
