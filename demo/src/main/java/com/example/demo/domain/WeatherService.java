package com.example.demo.domain;

import com.example.demo.domain.model.Forecast;

import java.io.IOException;
import java.util.List;

public interface WeatherService {

    List<Forecast> getForecast();
}
