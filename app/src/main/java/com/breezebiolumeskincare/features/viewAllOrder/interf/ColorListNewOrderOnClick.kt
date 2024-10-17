package com.breezebiolumeskincare.features.viewAllOrder.interf

import com.breezebiolumeskincare.app.domain.NewOrderColorEntity
import com.breezebiolumeskincare.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}