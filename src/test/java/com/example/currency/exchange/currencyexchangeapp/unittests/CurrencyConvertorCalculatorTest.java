package com.example.currency.exchange.currencyexchangeapp.unittests;

import com.example.currency.exchange.currencyexchangeapp.bean.CurrencyConversionBean;
import com.example.currency.exchange.currencyexchangeapp.controller.CurrencyConvertorCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyConvertorCalculatorTest {

    @Test
    void testGetConversionDetails_RestClientException() {

        RestTemplate restTemplate = mock(RestTemplate.class);
        CurrencyConvertorCalculator calculator = new CurrencyConvertorCalculator();

        String fromCurrency = "USD";
        String toCurrency = "EUR";
        BigDecimal quantity = BigDecimal.TEN;

        String apiKey = "testApiKey";

        when(restTemplate.getForEntity(
                "http://localhost:8001/currency-service/from/{from}/to/{to}?access_key={access_key}",
                CurrencyConversionBean.class, fromCurrency, toCurrency, apiKey))
                .thenThrow(RestClientException.class);
    }

    @Test
    void testGetConversionDetails_SuccessfulResponse() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        CurrencyConvertorCalculator calculator = new CurrencyConvertorCalculator();


        // Set up the parameters
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        BigDecimal quantity = BigDecimal.TEN;

        String apiKey = "testApiKey";

        CurrencyConversionBean responseBean = new CurrencyConversionBean();
        responseBean.setId(1001); // Set any desired values for the response bean
        responseBean.setFrom(fromCurrency);
        responseBean.setTo(toCurrency);
        responseBean.setExchangeRate(BigDecimal.valueOf(73)); // Set any desired conversion multiple
        responseBean.setQuantity(quantity);

        if (responseBean.getQuantity() != null && responseBean.getTotalCalAmount() != null) {
            responseBean.setTotalCalAmount(responseBean.getQuantity().multiply(responseBean.getTotalCalAmount()));
        } else {
            responseBean.setTotalCalAmount(BigDecimal.ZERO);
        }

        ResponseEntity<CurrencyConversionBean> responseEntity = new ResponseEntity<>(responseBean, HttpStatus.OK);
        when(restTemplate.getForEntity(
                "http://localhost:8001/currency-service/from/{from}/to/{to}?access_key={access_key}",
                CurrencyConversionBean.class, fromCurrency, toCurrency, apiKey))
                .thenReturn(responseEntity);

        CurrencyConversionBean result = calculator.getConversionDetails(fromCurrency, toCurrency, quantity);
    }
}