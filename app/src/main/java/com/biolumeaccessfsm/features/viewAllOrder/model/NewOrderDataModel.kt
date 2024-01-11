package com.biolumeaccessfsm.features.viewAllOrder.model

import com.biolumeaccessfsm.app.domain.NewOrderColorEntity
import com.biolumeaccessfsm.app.domain.NewOrderGenderEntity
import com.biolumeaccessfsm.app.domain.NewOrderProductEntity
import com.biolumeaccessfsm.app.domain.NewOrderSizeEntity
import com.biolumeaccessfsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

