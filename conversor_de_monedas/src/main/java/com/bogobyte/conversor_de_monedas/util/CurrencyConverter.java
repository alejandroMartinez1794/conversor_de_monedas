package com.bogobyte.conversor_de_monedas.util;

public class CurrencyConverter {

    /**
     * Convierte un monto de una moneda a otra utilizando las tasas de cambio proporcionadas.
     * Ahora, el resultado se redondeará al número entero más cercano.
     *
     * @param amount El monto a convertir.
     * @param rateFrom La tasa de cambio de la moneda origen.
     * @param rateTo La tasa de cambio de la moneda destino.
     * @return El monto convertido en la moneda destino, redondeado al entero más cercano.
     */
    public static long convertCurrency(double amount, double rateFrom, double rateTo) {
        // Convertir el monto a la moneda base (asumiendo que la tasa es respecto a la misma base para ambas monedas)
        // Esto se hace dividiendo el monto por la tasa de la moneda de origen.
        double amountInBase = amount / rateFrom;

        // Convertir el monto de la moneda base a la moneda destino
        // Esto se hace multiplicando el monto en la moneda base por la tasa de la moneda destino.
        double convertedAmount = amountInBase * rateTo;

        // Redondear el monto convertido al número entero más cercano
        // Utiliza Math.round para asegurar que el resultado sea un entero.
        return Math.round(convertedAmount);
    }
}