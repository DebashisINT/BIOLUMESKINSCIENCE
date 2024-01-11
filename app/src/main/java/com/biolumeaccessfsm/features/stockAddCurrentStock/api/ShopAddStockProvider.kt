package com.biolumeaccessfsm.features.stockAddCurrentStock.api

import com.biolumeaccessfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.biolumeaccessfsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}