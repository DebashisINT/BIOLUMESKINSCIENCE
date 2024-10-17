package com.breezebiolumeskincare.features.viewAllOrder.interf

import com.breezebiolumeskincare.app.domain.NewOrderGenderEntity
import com.breezebiolumeskincare.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}