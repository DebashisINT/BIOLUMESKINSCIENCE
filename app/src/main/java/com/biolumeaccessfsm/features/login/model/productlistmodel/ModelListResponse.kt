package com.biolumeaccessfsm.features.login.model.productlistmodel

import com.biolumeaccessfsm.app.domain.ModelEntity
import com.biolumeaccessfsm.app.domain.ProductListEntity
import com.biolumeaccessfsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}