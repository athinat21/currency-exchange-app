package com.example.currency.exchange.currencyexchangeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity

public class CurrencyExchangeRate {

    @Id
    private int id;

    @Column(name = "exchange_from")
    private String from;

    @Column(name = "exchange_to")
    private String to;
    private BigDecimal exchangeRate;

    protected CurrencyExchangeRate(){

    }

    public CurrencyExchangeRate(int id, String from, String to, BigDecimal exchangeRate) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.exchangeRate = exchangeRate;
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

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
