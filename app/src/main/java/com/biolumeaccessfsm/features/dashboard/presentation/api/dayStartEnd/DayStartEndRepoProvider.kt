package com.biolumeaccessfsm.features.dashboard.presentation.api.dayStartEnd

import com.biolumeaccessfsm.features.stockCompetetorStock.api.AddCompStockApi
import com.biolumeaccessfsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}