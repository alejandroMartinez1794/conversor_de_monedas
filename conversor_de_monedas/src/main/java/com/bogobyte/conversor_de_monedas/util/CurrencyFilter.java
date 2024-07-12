package com.bogobyte.conversor_de_monedas.util;

import com.bogobyte.conversor_de_monedas.model.ExchangeRateResponse;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyFilter {

    public static final List<String> ALLOWED_CURRENCY_CODES = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");

    public static Map<String, Double> filterCurrencies(String jsonResponse) {
        Gson gson = new Gson();
        ExchangeRateResponse response = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
        Map<String, Double> filteredRates = new HashMap<>();

        for (String currency : ALLOWED_CURRENCY_CODES) {
            if (response.getRates().containsKey(currency)) {
                filteredRates.put(currency, response.getRates().get(currency));
            }
        }

        return filteredRates;
    }
}