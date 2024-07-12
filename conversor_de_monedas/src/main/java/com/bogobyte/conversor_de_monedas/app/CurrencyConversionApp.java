package com.bogobyte.conversor_de_monedas.app;

import com.bogobyte.conversor_de_monedas.client.ExchangeRateClient;
import com.bogobyte.conversor_de_monedas.util.CurrencyConverter;
import com.bogobyte.conversor_de_monedas.util.CurrencyFilter;

import java.util.Map;
import java.util.Scanner;

public class CurrencyConversionApp {

    private static boolean isRunning = true; // Variable de control para el bucle principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (isRunning) { // Usa la variable de control en el bucle
            runApplication(scanner);
            if (!isRunning) {
                System.out.println("\n==========🙏 Gracias por usar el conversor de monedas. 🌐==============");
            }
        }
    }

    private static void runApplication(Scanner scanner) {
        boolean continuar = true;
        boolean mostrarMensajes = true;
        ExchangeRateClient client = new ExchangeRateClient();

        while (continuar) {

            if (mostrarMensajes) {
                System.out.println("\n=========================================");
                System.out.println("🌍 Bienvenido al Conversor de Monedas 🌍");
                System.out.println("Una herramienta rápida y fácil para tus necesidades de conversión monetaria.");
                System.out.println("=========================================");
            }

            System.out.println("\n📋 Monedas disponibles: " + CurrencyFilter.ALLOWED_CURRENCY_CODES);
            System.out.println("1. Convertir monedas");
            System.out.println("2. Salir");
            System.out.print("👉 Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código de la moneda origen (ej. USD): ");
                    String baseCurrency = scanner.next().toUpperCase();

                    String jsonResponse = client.fetchExchangeRates(baseCurrency);
                    Map<String, Double> filteredRates = CurrencyFilter.filterCurrencies(jsonResponse);

                    System.out.print("Ingrese el código de la moneda destino (ej. EUR): ");
                    String targetCurrency = scanner.next().toUpperCase();

                    if (!filteredRates.containsKey(targetCurrency)) {
                        System.out.println("❌ Moneda destino no disponible. Por favor, elija otra.");
                        break;
                    }

                    System.out.print("Ingrese el monto a convertir (ej. 100): ");
                    double amount = scanner.nextDouble();

                    double rateFrom = 1.0;
                    double rateTo = filteredRates.get(targetCurrency);

                    long convertedAmount = CurrencyConverter.convertCurrency(amount, rateFrom, rateTo);
                    String formattedAmount = String.format("%,d", convertedAmount);
                    System.out.println("💰 Monto convertido: " + formattedAmount + " " + targetCurrency);

                    System.out.println("\n¿Qué desea hacer a continuación?");
                    System.out.println("1. Convertir una nueva moneda");
                    System.out.println("2. Salir");
                    System.out.print("👉 Seleccione una opción: ");
                    int opcionPostConversion = scanner.nextInt();
                    if (opcionPostConversion == 2) {
                        continuar = false;
                        isRunning = false;
                    } else if (opcionPostConversion != 1) {
                        System.out.println("❌ Opción no válida. Por favor, intente de nuevo.");
                    }
                    mostrarMensajes = false;
                    break;
                case 2:
                    continuar = false;
                    isRunning = false;
                    break;
                default:
                    System.out.println("❌ Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}