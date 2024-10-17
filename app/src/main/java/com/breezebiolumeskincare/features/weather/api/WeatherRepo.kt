package com.breezebiolumeskincare.features.weather.api

import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.task.api.TaskApi
import com.breezebiolumeskincare.features.task.model.AddTaskInputModel
import com.breezebiolumeskincare.features.weather.model.ForeCastAPIResponse
import com.breezebiolumeskincare.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}