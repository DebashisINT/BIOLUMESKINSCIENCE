package com.biolumeaccessfsm.features.location.shopRevisitStatus

import com.biolumeaccessfsm.features.location.shopdurationapi.ShopDurationApi
import com.biolumeaccessfsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}