package com.bogobyte.conversor_de_monedas.model;

import java.util.Map;

/**
 * Clase que representa la respuesta de la API de tasas de cambio.
 * Esta clase se utiliza para deserializar la respuesta JSON obtenida de la API a un objeto Java.
 */
public class ExchangeRateResponse {
    // Campo que almacena la moneda base de la consulta de tasas de cambio.
    private String base;
    // Mapa que almacena las tasas de cambio, donde la clave es el código de la moneda y el valor es la tasa de cambio.
    private Map<String, Double> rates;

    /**
     * Obtiene la moneda base de la respuesta.
     * @return La moneda base como una cadena de texto.
     */
    public String getBase() {
        return base;
    }

    /**
     * Establece la moneda base de la respuesta.
     * @param base La moneda base como una cadena de texto.
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Obtiene las tasas de cambio de la respuesta.
     * @return Un mapa con las tasas de cambio, donde cada clave es el código de una moneda y cada valor es la tasa de cambio correspondiente.
     */
    public Map<String, Double> getRates() {
        return rates;
    }

    /**
     * Establece las tasas de cambio de la respuesta.
     * @param rates Un mapa con las tasas de cambio, donde cada clave es el código de una moneda y cada valor es la tasa de cambio correspondiente.
     */
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}