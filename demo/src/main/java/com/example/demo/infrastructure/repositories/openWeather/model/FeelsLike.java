package com.example.demo.infrastructure.repositories.openWeather.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class FeelsLike {
    private double day;
    private double night;
    private double eve;
    private double morn;
}
