package com.breezebiolumeskincare.features.login.model.productlistmodel

import com.breezebiolumeskincare.app.domain.ModelEntity
import com.breezebiolumeskincare.app.domain.ProductListEntity
import com.breezebiolumeskincare.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}