package com.amurta.bhut.service;


import com.amurta.bhut.model.Car;
import org.springframework.stereotype.Service;
import util.GsonUtil;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Collection;

@Service
public final class CarService {

private  HttpService httpService;

    public CarService(HttpService httpService) {
        this.httpService = httpService;
    }

    public Collection<Car> buscaCarros() {
        try {
            HttpResponse<String> response = httpService.getStringHttpResponse();
            Collection<Car> colCars = GsonUtil.fromJson(response.body(), GsonUtil.getColletionType(new Car()));
            return colCars;
        } catch (Exception e) {
            return null;
        }
    }

    public Car salvarCarro(Car carro) {
        try {
            String data = GsonUtil.toJson(carro);
            HttpResponse<String> response =  httpService.postStringHttpResponse(  data);
            Car car = GsonUtil.fromJson(response.body(),  Car.class);
            return car;
        } catch (Exception e) {
            return null;
        }
    }



}
