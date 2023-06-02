package com.techelevator.api.model;

import java.util.List;

public class ApiStockModel {
    private boolean adjusted;
    private int queryCount;
    private String requestId;
    private int resultsCount;
    private String status;
    private String ticker;
    private List<ResultsModel> results;

    public ApiStockModel(boolean adjusted, int queryCount, String requestId, int resultsCount, String status, String ticker, List<ResultsModel> results) {
        this.adjusted = adjusted;
        this.queryCount = queryCount;
        this.requestId = requestId;
        this.resultsCount = resultsCount;
        this.status = status;
        this.ticker = ticker;
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

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String stockTicker) {
        this.ticker = stockTicker;
    }

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;

    }
}