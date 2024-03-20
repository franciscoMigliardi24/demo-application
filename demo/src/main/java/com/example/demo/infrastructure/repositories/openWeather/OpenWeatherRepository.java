package com.example.demo.infrastructure.repositories.openWeather;

import com.example.demo.domain.WeatherRepository;
import com.example.demo.domain.model.Forecast;
import com.example.demo.domain.query.ForecastQuery;
import com.example.demo.infrastructure.repositories.openWeather.config.ConfigProperties;
import com.example.demo.infrastructure.repositories.openWeather.error.RestClientError;
import com.example.demo.infrastructure.repositories.openWeather.model.GetForecastResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@Repository
@AllArgsConstructor
public class OpenWeatherRepository implements WeatherRepository {

    private ConfigProperties configProperties;
    @Override
    public List<Forecast> findForecastByLatitudeAndLongitude() {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.openweathermap.org/data/3.0/onecall?lat=" +
                            configProperties.latitude + "&lon=" + configProperties.longitude + "&appid=" + configProperties.apiKey)
                    .build();

            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            GetForecastResponse bodyResponse = gson.fromJson(response.body().string(), GetForecastResponse.class);
            List<Forecast> forecastList = new ArrayList<>();
            for (int i = 0; i < bodyResponse.getHourly().size(); i++) {
                forecastList.add(Forecast.builder()
                        .date(new Date(bodyResponse.getHourly().get(i).getDt()).toString())
                        .temperature(Double.toString(bodyResponse.getHourly().get(i).getTemp() + 273.15))
                        .build());
            }


            return forecastList;
        } catch (IOException e) {
            log.error("Error getting forecast", e);
            throw new RestClientError(e.toString());
        }
    }
}
