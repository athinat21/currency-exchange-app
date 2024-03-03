package com.example.currency.exchange.currencyexchangeapp.bean;

import java.math.BigDecimal;
import java.util.Objects;

public class CurrencyConversionBean {

    private int id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal exchangeRate;
    private BigDecimal totalCalAmount;


    public CurrencyConversionBean(){

    }

    public CurrencyConversionBean(int id, String from, String to, BigDecimal quantity, BigDecimal exchangeRate, BigDecimal totalCalAmount) {
      super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
        this.totalCalAmount = totalCalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getTotalCalAmount() {
        return totalCalAmount;
    }

    public void setTotalCalAmount(BigDecimal totalCalAmount) {
        this.totalCalAmount = totalCalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyConversionBean that = (CurrencyConversionBean) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(exchangeRate, that.exchangeRate) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(totalCalAmount, that.totalCalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, exchangeRate, quantity, totalCalAmount);
    }
}
