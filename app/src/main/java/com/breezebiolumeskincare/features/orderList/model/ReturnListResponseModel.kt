package com.breezebiolumeskincare.features.orderList.model

import com.breezebiolumeskincare.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}