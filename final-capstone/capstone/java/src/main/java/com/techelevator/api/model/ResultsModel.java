package com.techelevator.api.model;

public class ResultsModel {

    private double close;
    private long volume;
    private String status;
    private String symbol;

    public ResultsModel() {

    }

    public ResultsModel(double close, long volume, String status, String symbol) {
        this.close = close;
        this.volume = volume;
        this.status = status;
        this.symbol = symbol;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
