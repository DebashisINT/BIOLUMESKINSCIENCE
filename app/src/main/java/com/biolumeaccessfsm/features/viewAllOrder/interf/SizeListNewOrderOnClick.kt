package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.app.domain.NewOrderProductEntity
import com.biolumeaccessfsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}