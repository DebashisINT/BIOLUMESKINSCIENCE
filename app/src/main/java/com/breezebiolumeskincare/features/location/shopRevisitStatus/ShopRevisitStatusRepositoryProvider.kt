package com.breezebiolumeskincare.features.location.shopRevisitStatus

import com.breezebiolumeskincare.features.location.shopdurationapi.ShopDurationApi
import com.breezebiolumeskincare.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}