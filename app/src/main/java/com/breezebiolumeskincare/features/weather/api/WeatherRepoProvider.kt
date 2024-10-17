package com.breezebiolumeskincare.features.weather.api

import com.breezebiolumeskincare.features.task.api.TaskApi
import com.breezebiolumeskincare.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}