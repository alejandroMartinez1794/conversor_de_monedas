package com.bogobyte.conversor_de_monedas.app;

import com.bogobyte.conversor_de_monedas.util.CurrencyConverter;
import java.util.Scanner;

public class CurrencyConversionApp {

    public static void main(String[] args) {
        // Crear una instancia de Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Variable para controlar el bucle del menú
        boolean continuar = true;

        // Bucle principal del programa
        while (continuar) {
            // Mostrar el menú de opciones al usuario
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            // Leer la opción seleccionada por el usuario
            int opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Solicitar al usuario el monto a convertir
                    System.out.print("Ingrese el monto a convertir: ");
                    double amount = scanner.nextDouble();

                    // Solicitar la tasa de cambio de la moneda origen
                    System.out.print("Ingrese la tasa de cambio de la moneda origen: ");
                    double rateFrom = scanner.nextDouble();

                    // Solicitar la tasa de cambio de la moneda destino
                    System.out.print("Ingrese la tasa de cambio de la moneda destino: ");
                    double rateTo = scanner.nextDouble();

                    // Realizar la conversión y mostrar el resultado
                    double convertedAmount = CurrencyConverter.convertCurrency(amount, rateFrom, rateTo);
                    System.out.println("Monto convertido: " + convertedAmount);
                    break;
                case 2:
                    // Cambiar el valor de continuar a false para salir del bucle y terminar el programa
                    continuar = false;
                    break;
                default:
                    // Informar al usuario que ha seleccionado una opción no válida
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        // Mensaje de despedida al salir del programa
        System.out.println("Gracias por usar el conversor de monedas.");
    }
}