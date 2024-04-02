package com.spring.batch.xml;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;

// 定义生成XML文件的根标签
// <?xml version="1.0" encoding="UTF-8"?>
// <transactionRecord>
// </transactionRecord>
@XmlRootElement(name = "transactionRecord")
public class Transaction {

    private String username;
    private int userId;
    private LocalDate date;
    private double amount;

    public Transaction() {
    }

    public Transaction(String username, int userId, LocalDate date, double amount) {
        this.username = username;
        this.userId = userId;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                + ", date=" + date + ", amount=" + amount + "]";
    }
}
