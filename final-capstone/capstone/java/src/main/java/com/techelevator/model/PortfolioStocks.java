package com.techelevator.model;

public class PortfolioStocks {

    private int id;
    private int portfolioId;
    private String ticker;
    private int quantity;

    public PortfolioStocks() {

    }

    public PortfolioStocks(int id, int portfolioId, String ticker, int quantity) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPortfolioId() {
        return portfolioId;
    }
    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
