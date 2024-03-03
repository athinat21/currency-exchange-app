package com.example.currency.exchange.currencyexchangeapp.unittests;

import com.example.currency.exchange.currencyexchangeapp.controller.CurrencyExchangeController;
import com.example.currency.exchange.currencyexchangeapp.entity.CurrencyExchangeRate;
import com.example.currency.exchange.currencyexchangeapp.repository.ExchangeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CurrencyExchangeControllerTest {

    @Mock
    ExchangeRepository exchangeRepository;

    @InjectMocks
    private CurrencyExchangeController controller;

    @InjectMocks
    CurrencyExchangeController currencyExchangeController;

    @Test
    void getCurrencyExchangeRate_ReturnsCurrencyExchangeRate() {

        String from = "USD";
        String to = "EUR";
        CurrencyExchangeRate expectedRate = new CurrencyExchangeRate(1, from, to, BigDecimal.valueOf(0.89));

        when(exchangeRepository.findByFromAndTo(from, to)).thenReturn(expectedRate);

        CurrencyExchangeRate actualRate = currencyExchangeController.getCurrencyExchangeRate(from, to);

        assertEquals(expectedRate, actualRate);
    }
}
