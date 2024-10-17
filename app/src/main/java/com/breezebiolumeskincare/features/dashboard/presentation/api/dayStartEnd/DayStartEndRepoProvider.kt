package com.breezebiolumeskincare.features.dashboard.presentation.api.dayStartEnd

import com.breezebiolumeskincare.features.stockCompetetorStock.api.AddCompStockApi
import com.breezebiolumeskincare.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}