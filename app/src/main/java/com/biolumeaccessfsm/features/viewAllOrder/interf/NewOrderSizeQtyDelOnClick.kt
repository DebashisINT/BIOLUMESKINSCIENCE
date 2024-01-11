package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.app.domain.NewOrderGenderEntity
import com.biolumeaccessfsm.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}