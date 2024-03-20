package com.example.demo.infrastructure.repositories.openWeather.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Builder
@ToString
public class GetForecastResponse {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private Current current;
    private ArrayList<Minutely> minutely;
    private ArrayList<Hourly> hourly;
    private ArrayList<Daily> daily;
}
