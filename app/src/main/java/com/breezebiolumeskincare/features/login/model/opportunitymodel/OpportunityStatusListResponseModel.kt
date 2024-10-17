package com.breezebiolumeskincare.features.login.model.opportunitymodel

import com.breezebiolumeskincare.app.domain.OpportunityStatusEntity
import com.breezebiolumeskincare.app.domain.ProductListEntity
import com.breezebiolumeskincare.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}