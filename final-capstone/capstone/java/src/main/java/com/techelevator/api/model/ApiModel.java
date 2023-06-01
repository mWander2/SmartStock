package com.techelevator.api.model;

public class ApiModel {

    private double closePrice;
    private int transactions;
    private String status;
    private String ticker;

    public ApiModel(double closePrice, int transactions, String status, String ticker) {
        this.closePrice = closePrice;
        this.transactions = transactions;
        this.status = status;
        this.ticker = ticker;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public int getTransactions() {
        return transactions;
    }

    public String getStatus() {
        return status;
    }

    public String getTicker() {
        return ticker;
    }
}


