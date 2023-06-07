package com.techelevator.model;

import com.techelevator.api.model.ResultsModel;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PortfolioStocks {
    private int id;
    private int portfolioId;
    private String ticker;
    private int quantity;
    private BigDecimal value;
    private ResultsModel resultsModel;

    public PortfolioStocks() {
    }

    public PortfolioStocks(int id, int portfolioId, String ticker, int quantity, BigDecimal value, ResultsModel resultsModel) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.quantity = quantity;
        this.value = value;
        this.resultsModel = resultsModel;
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

    public BigDecimal calculateValue() {
        BigDecimal value = resultsModel.getClose().multiply(BigDecimal.valueOf(quantity));
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ResultsModel getResultsModel() {
        return resultsModel;
    }

    public void setResultsModel(ResultsModel resultsModel) {
        this.resultsModel = resultsModel;
    }
}
