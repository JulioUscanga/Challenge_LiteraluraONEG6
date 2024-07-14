package com.cursoalura.literalura_challenge.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionUrl {
    private HttpClient client;

    public ConexionUrl() {
        client = HttpClient.newHttpClient();
    }

    public String consultar(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Se debe cerrar el HttpClient cuando ya no se necesite
        // client.close();

        return response.body();
    }
}
