package com.amurta.bhut.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Alexandre Murta
 */
@Getter
@Setter
public class Car {
    private String _id;
    private String title;
    private String brand;
    private String price;
    private Integer age;
    private Integer __v;
}
