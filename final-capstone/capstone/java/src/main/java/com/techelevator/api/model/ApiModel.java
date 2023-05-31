package com.techelevator.api.model;

public class ApiModel {

    private int closePrice;
    private int highPrice;
    private int lowPrice;
    private int openPrice;
    private int timeStamp;

    private String ticker;
    private Boolean isAdjusted;
//    private int queryCount;
//    private String requestId;
    private int resultsCount;
    private String status;

    public ApiModel(int closePrice, int highPrice, int lowPrice, int openPrice, int timeStamp, int volume,
                    String ticker, Boolean isAdjusted, int queryCount, String requestId, int resultsCount, String status) {
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.openPrice = openPrice;
        this.timeStamp = timeStamp;
        this.ticker = ticker;
        this.isAdjusted = isAdjusted;
//        this.queryCount = queryCount;
//        this.requestId = requestId;
        this.resultsCount = resultsCount;
        this.status = status;
    }

    public int getClosePrice() {
        return closePrice;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public int getOpenPrice() {
        return openPrice;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

//    public int getVolume() {
//        return volume;
//    }

    public String getTicker() {
        return ticker;
    }

    public Boolean getAdjusted() {
        return isAdjusted;
    }

//    public int getQueryCount() {
//        return queryCount;
//    }
//
//    public String getRequestId() {
//        return requestId;
//    }

    public int getResultsCount() {
        return resultsCount;
    }

    public String getStatus() {
        return status;
    }
}
