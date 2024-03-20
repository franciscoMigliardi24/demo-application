package com.example.demo.domain;

import com.example.demo.domain.model.Forecast;

import java.util.List;


public interface WeatherRepository {
    List<Forecast> findForecastByLatitudeAndLongitude();
}
