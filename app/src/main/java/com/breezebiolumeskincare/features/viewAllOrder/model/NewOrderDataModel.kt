package com.breezebiolumeskincare.features.viewAllOrder.model

import com.breezebiolumeskincare.app.domain.NewOrderColorEntity
import com.breezebiolumeskincare.app.domain.NewOrderGenderEntity
import com.breezebiolumeskincare.app.domain.NewOrderProductEntity
import com.breezebiolumeskincare.app.domain.NewOrderSizeEntity
import com.breezebiolumeskincare.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

