package com.amurta.bhut.service;


import com.amurta.bhut.entity.LogCar;
import com.amurta.bhut.repository.LogCarRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;


@Service
public final class LogCarService {

    private final LogCarRepository logCarRepository;

    public LogCarService(LogCarRepository logCarRepository) {
        this.logCarRepository = logCarRepository;
    }

    public UUID addlog( LogCar logCar)
    {
        logCar = logCarRepository.save(logCar);
         return logCar.getId();
    }

    public Collection<LogCar> buscarLogs(){
        return logCarRepository.findAll();
    }

}
