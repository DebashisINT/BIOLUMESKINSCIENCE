package com.breezebiolumeskincare.features.stockAddCurrentStock.api

import com.breezebiolumeskincare.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezebiolumeskincare.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}