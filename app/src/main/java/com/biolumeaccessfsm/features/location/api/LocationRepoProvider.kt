package com.biolumeaccessfsm.features.location.api

import com.biolumeaccessfsm.features.location.shopdurationapi.ShopDurationApi
import com.biolumeaccessfsm.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}