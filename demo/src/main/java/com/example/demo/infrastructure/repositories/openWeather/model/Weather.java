package com.example.demo.infrastructure.repositories.openWeather.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Weather {
    private int id;
    private String main;
}
