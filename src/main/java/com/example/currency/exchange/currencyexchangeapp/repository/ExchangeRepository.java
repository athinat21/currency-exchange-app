package com.example.currency.exchange.currencyexchangeapp.repository;

import com.example.currency.exchange.currencyexchangeapp.entity.CurrencyExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository  extends JpaRepository<CurrencyExchangeRate, Long> {
    //Query method
    CurrencyExchangeRate findByFromAndTo(String from, String to);
}
