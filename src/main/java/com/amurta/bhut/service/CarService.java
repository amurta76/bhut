package com.amurta.bhut.service;


import com.amurta.bhut.model.Car;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import util.GsonUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.UUID;

@Service
public final class CarService {


    public Collection<Car> buscaCarros() {

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        String apiCarro = "http://157.230.213.199:3000/api/cars";

        try {
            response = getStringHttpResponse(apiCarro, client);
            Collection<Car> colCars = GsonUtil.fromJson(response.body(), GsonUtil.getColletionType(new Car()));
            return colCars;
        } catch (Exception e) {
            return null;
        }

    }

    public Car salvarCarro(Car carro) {



        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        String apiCarro = "http://157.230.213.199:3000/api/cars";

        try {
            String data = GsonUtil.toJson(carro);

            response = postStringHttpResponse(apiCarro, client, data);
            Car car = GsonUtil.fromJson(response.body(),  Car.class);
            return car;
        } catch (Exception e) {
            return null;
        }
    }


    private static HttpResponse<String> getStringHttpResponse(String urlServidor, HttpClient client) throws IOException, InterruptedException {
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf8")
                .uri(URI.create(urlServidor))
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }

    private static HttpResponse<String> postStringHttpResponse(String urlServidor, HttpClient client, String data) throws IOException, InterruptedException {
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf8")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .uri(URI.create(urlServidor))
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }

}
