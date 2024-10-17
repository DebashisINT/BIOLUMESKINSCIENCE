package com.breezebiolumeskincare.features.location.api

import com.breezebiolumeskincare.features.location.shopdurationapi.ShopDurationApi
import com.breezebiolumeskincare.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}