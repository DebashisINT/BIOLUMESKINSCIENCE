package com.biolumeaccessfsm.features.weather.api

import com.biolumeaccessfsm.features.task.api.TaskApi
import com.biolumeaccessfsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}