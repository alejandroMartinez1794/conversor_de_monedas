package com.bogobyte.conversor_de_monedas.client;

// Importar clases necesarias para manejar solicitudes y respuestas HTTP, y gestionar URIs y excepciones
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

// Definir la clase ExchangeRateClient
public class ExchangeRateClient {

    // Clave API para la autenticación con el servicio ExchangeRate-API
    private static final String API_KEY = "63a3c6cef8d3667a706df309";
    // URL base del servicio ExchangeRate-API
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    // Método para obtener las tasas de cambio para una moneda base dada
    public String fetchExchangeRates(String baseCurrency) {
        // Construir la URL completa para la solicitud añadiendo la moneda base y la clave API a la URL base
        String urlWithParameters = BASE_URL + baseCurrency + "?apiKey=" + API_KEY;

        // Crear una nueva instancia de HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Construir la solicitud HTTP con la URL construida y configurarla para usar el método GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlWithParameters))
                .GET()
                .build();

        try {
            // Enviar la solicitud y recibir la respuesta como un String
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            // Verificar si el código de estado de la respuesta es 200 (OK)
            if (response.statusCode() == 200) {
                // Devolver el cuerpo de la respuesta
                return response.body();
            } else {
                // Devolver un mensaje de error con el código de estado si la respuesta no es OK
                return "Error: " + response.statusCode();
            }
        } catch (IOException | InterruptedException e) {
            // Interrumpir el hilo actual si ocurre una InterruptedException
            Thread.currentThread().interrupt();
            // Devolver un mensaje de error con el mensaje de la excepción
            return "Error: " + e.getMessage();
        }
    }
}
