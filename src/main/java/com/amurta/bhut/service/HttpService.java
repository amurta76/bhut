package com.amurta.bhut.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpService {

    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response = null;
    String apiCarro = "http://157.230.213.199:3000/api/cars";


    public HttpResponse<String> getStringHttpResponse() throws IOException, InterruptedException {
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf8")
                .uri(URI.create(apiCarro))
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> postStringHttpResponse(String data) throws IOException, InterruptedException {
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf8")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .uri(URI.create(apiCarro))
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }

}
