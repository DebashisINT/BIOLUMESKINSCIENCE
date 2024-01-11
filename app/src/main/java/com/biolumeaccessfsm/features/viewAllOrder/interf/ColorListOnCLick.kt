package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.app.domain.NewOrderGenderEntity
import com.biolumeaccessfsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}