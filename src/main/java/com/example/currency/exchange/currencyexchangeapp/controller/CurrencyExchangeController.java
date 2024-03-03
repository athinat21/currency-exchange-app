package com.example.currency.exchange.currencyexchangeapp.controller;

import com.example.currency.exchange.currencyexchangeapp.entity.CurrencyExchangeRate;
import com.example.currency.exchange.currencyexchangeapp.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    ExchangeRepository exchangeRepository;

    @GetMapping("/currency-service/from/{from}/to/{to}")
    public CurrencyExchangeRate getCurrencyExchangeRate(@PathVariable String from, @PathVariable String to) {

        CurrencyExchangeRate currencyExchangeRate = exchangeRepository.findByFromAndTo(from, to);

        return currencyExchangeRate ;
    }
}
