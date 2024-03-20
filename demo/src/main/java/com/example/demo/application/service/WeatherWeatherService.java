package com.example.demo.application.service;

import com.example.demo.domain.WeatherRepository;
import com.example.demo.domain.query.ForecastQuery;
import com.example.demo.domain.WeatherService;
import com.example.demo.domain.model.Forecast;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Log4j2
public class WeatherWeatherService implements WeatherService {
    private final WeatherRepository weatherRepository;
    @Override
    public List<Forecast> getForecast() {
        return weatherRepository.findForecastByLatitudeAndLongitude();
    }
}
