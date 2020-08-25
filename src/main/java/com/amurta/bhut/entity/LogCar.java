package com.amurta.bhut.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LogCar {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;

    private LocalDateTime data_hora;

    private String log;

    private String car_id;

    private UUID idLogPai;
}
