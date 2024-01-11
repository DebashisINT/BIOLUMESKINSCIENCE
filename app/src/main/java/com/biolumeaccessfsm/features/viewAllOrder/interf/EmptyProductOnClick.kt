package com.biolumeaccessfsm.features.viewAllOrder.interf

import com.biolumeaccessfsm.features.viewAllOrder.model.ProductOrder

interface EmptyProductOnClick {
    fun emptyProductOnCLick(emptyFound:Boolean)
    fun delProductOnCLick(isDel:Boolean)
}