package com.techelevator.api.model;

public class ResultsModel {

    private double closePrice;
    private int transactions;
    private String status;
    private String ticker;

    public ResultsModel() {

    }

    public ResultsModel(double closePrice, int transactions, String status, String ticker) {
        this.closePrice = closePrice;
        this.transactions = transactions;
        this.status = status;
        this.ticker = ticker;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
