package com.breezebiolumeskincare.features.viewAllOrder.interf

import com.breezebiolumeskincare.app.domain.NewOrderProductEntity
import com.breezebiolumeskincare.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}