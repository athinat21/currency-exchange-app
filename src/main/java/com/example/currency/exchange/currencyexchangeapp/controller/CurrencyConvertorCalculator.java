package com.example.currency.exchange.currencyexchangeapp.controller;

import com.example.currency.exchange.currencyexchangeapp.bean.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertorCalculator {

    @Value("${endpoints.access-key}")
    private String apiKey;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean getConversionDetails (@PathVariable("from") String from,
                                                        @PathVariable("to") String to,
                                                        @PathVariable("quantity") BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        uriVariables.put("access_key", apiKey); // Injecting API key here

        ResponseEntity<CurrencyConversionBean> responseEntity = null;

        try {
            responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-service/from/{from}/to/{to}?access_key={access_key}", CurrencyConversionBean.class,
                    uriVariables);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                CurrencyConversionBean response = responseEntity.getBody();
                if (response != null) {
                    return new CurrencyConversionBean(response.getId(), from, to, quantity, response.getExchangeRate(), quantity.multiply(response.getExchangeRate()));
                } else {

                    return new CurrencyConversionBean();
                }
            } else {
                return new CurrencyConversionBean();
            }
        } catch (RestClientException e) {
            e.printStackTrace();
            return new CurrencyConversionBean();
        }
    }
}