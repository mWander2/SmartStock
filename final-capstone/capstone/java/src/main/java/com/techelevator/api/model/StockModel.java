package com.techelevator.api.model;

<<<<<<< HEAD
import java.util.List;

public class StockModel {
        private boolean adjusted;
        private int queryCount;
        private String requestId;
        private int resultsCount;
        private String status;
        private String stockTicker;
        private List<ResultsModel> results;

    public StockModel(boolean adjusted, int queryCount, String requestId, int resultsCount, String status, String ticker, List<ResultsModel> results) {
        this.adjusted = adjusted;
        this.queryCount = queryCount;
        this.requestId = requestId;
        this.resultsCount = resultsCount;
        this.status = status;
        this.stockTicker = ticker;
        this.results = results;
    }

    public boolean isAdjusted() {
        return adjusted;
    }

    public void setAdjusted(boolean adjusted) {
        this.adjusted = adjusted;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;
=======
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
>>>>>>> main
    }
}
