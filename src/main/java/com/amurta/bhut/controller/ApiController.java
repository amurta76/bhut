package com.amurta.bhut.controller;

import com.amurta.bhut.entity.LogCar;
import com.amurta.bhut.model.Car;
import com.amurta.bhut.service.CarService;
import com.amurta.bhut.service.LogCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.GsonUtil;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

/**
 * @author Alexandre Murta
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    private final CarService carService;
    private final LogCarService logCarService;

    public ApiController(CarService carService, LogCarService logCarService) {
        this.carService = carService;
        this.logCarService = logCarService;
    }

    @GetMapping(value = "listCars")
    public ResponseEntity<Collection<Car>> listCars() {
        try {
            Collection<Car> cars = carService.buscaCarros();
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(value = "createCar")
    public ResponseEntity<Car> createCar(@RequestBody Car carro) {
        UUID logPai = logCarService.addlog(new LogCar(null, LocalDateTime.now(), "Iniciando criação do carro:" + GsonUtil.toJson(carro), null, null));
        try {
            Car car = carService.salvarCarro(carro);
            logCarService.addlog(new LogCar(null, LocalDateTime.now(), "Carro Salvo com id :" + car.get_id(), car.get_id(), logPai));
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            logCarService.addlog(new LogCar(null, LocalDateTime.now(), "Erro ao salvar o carro:" + GsonUtil.toJson(carro) + " ERRO:" + e.getMessage(), null, logPai));
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping(value = "logs")
    public ResponseEntity<Collection<LogCar>> logs() {
        try {
            Collection<LogCar> logs = logCarService.buscarLogs();
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}

