package com.techelevator.api.model;

import java.math.BigDecimal;

public class StockModel {

    private BigDecimal currentPrice;
    private String ticker;
    private String stockName;

    public void ApiModel(String stockName, String ticker, BigDecimal currentPrice){
        this.currentPrice = currentPrice;
        this.stockName = stockName;
        this.ticker = ticker;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public String getStockName() {
        return stockName;
    }
}
