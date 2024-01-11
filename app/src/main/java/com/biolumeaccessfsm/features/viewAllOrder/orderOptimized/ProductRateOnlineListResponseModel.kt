package com.biolumeaccessfsm.features.viewAllOrder.orderOptimized

import com.biolumeaccessfsm.app.domain.ProductOnlineRateTempEntity
import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}