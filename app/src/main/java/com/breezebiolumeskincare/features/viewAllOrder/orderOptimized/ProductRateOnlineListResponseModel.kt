package com.breezebiolumeskincare.features.viewAllOrder.orderOptimized

import com.breezebiolumeskincare.app.domain.ProductOnlineRateTempEntity
import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}