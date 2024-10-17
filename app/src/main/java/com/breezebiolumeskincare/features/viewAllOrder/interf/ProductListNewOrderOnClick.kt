package com.breezebiolumeskincare.features.viewAllOrder.interf

import com.breezebiolumeskincare.app.domain.NewOrderGenderEntity
import com.breezebiolumeskincare.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}