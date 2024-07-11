package com.bogobyte.conversor_de_monedas.util;

public class CurrencyConverter {

    /**
     * Convierte un monto de una moneda a otra utilizando las tasas de cambio proporcionadas.
     *
     * @param amount El monto a convertir.
     * @param rateFrom La tasa de cambio de la moneda origen.
     * @param rateTo La tasa de cambio de la moneda destino.
     * @return El monto convertido en la moneda destino.
     */
    public static double convertCurrency(double amount, double rateFrom, double rateTo) {
        // Convertir el monto a la moneda base (asumiendo que la tasa es respecto a la misma base para ambas monedas)
        double amountInBase = amount / rateFrom;
        // Convertir el monto de la moneda base a la moneda destino
        return amountInBase * rateTo;
    }
}