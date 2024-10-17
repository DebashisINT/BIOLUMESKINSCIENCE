package com.breezebiolumeskincare.features.viewAllOrder.interf

import com.breezebiolumeskincare.app.domain.NewOrderGenderEntity
import com.breezebiolumeskincare.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}