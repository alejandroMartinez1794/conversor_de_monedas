package com.bogobyte.conversor_de_monedas.util;

import com.bogobyte.conversor_de_monedas.model.ExchangeRateResponse;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyFilter {

    public static Map<String, Double> filterCurrencies(String jsonResponse, List<String> currenciesToFilter) {
        Gson gson = new Gson();
        ExchangeRateResponse response = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
        Map<String, Double> filteredRates = new HashMap<>();

        for (String currency : currenciesToFilter) {
            if (response.getRates().containsKey(currency)) {
                filteredRates.put(currency, response.getRates().get(currency));
            }
        }

        return filteredRates;
    }
}