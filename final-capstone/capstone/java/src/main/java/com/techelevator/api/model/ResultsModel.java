package com.techelevator.api.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultsModel {
    private BigDecimal close;
    private long volume;
    private String status;
    private String symbol;
    private BigDecimal value;

    public ResultsModel() {
    }

    public ResultsModel(BigDecimal close, long volume, String status, String symbol) {
        this.close = close;
        this.volume = volume;
        this.status = status;
        this.symbol = symbol;
        this.value = calculateValue();
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal calculateValue() {
        BigDecimal value = close.multiply(BigDecimal.valueOf(volume));
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}