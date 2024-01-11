package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.app.domain.NewOrderGenderEntity
import com.biolumeaccessfsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}