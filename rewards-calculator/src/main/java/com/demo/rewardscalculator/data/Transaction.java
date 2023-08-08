package com.demo.rewardscalculator.data;

import java.time.LocalDate;

public class Transaction {

    private Customer customer;
    private Long transactionId;
    private double transactionAmount;
    private LocalDate transactionDate;

    public Transaction(Long transactionId, Customer customer, LocalDate transactionDate, double transactionAmount) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
