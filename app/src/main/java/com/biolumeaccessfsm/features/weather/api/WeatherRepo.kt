package com.biolumeaccessfsm.features.weather.api

import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.task.api.TaskApi
import com.biolumeaccessfsm.features.task.model.AddTaskInputModel
import com.biolumeaccessfsm.features.weather.model.ForeCastAPIResponse
import com.biolumeaccessfsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}