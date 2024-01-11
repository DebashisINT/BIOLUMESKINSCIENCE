package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.app.domain.NewOrderColorEntity
import com.biolumeaccessfsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}