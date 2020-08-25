package com.amurta.bhut.repository;

import com.amurta.bhut.entity.LogCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogCarRepository extends JpaRepository<LogCar, UUID> {


}
