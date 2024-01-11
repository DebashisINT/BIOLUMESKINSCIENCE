package com.biolumeaccessfsm.features.orderList.model

import com.biolumeaccessfsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}