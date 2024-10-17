package com.breezebiolumeskincare.features.location.shopRevisitStatus

import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.location.model.ShopDurationRequest
import com.breezebiolumeskincare.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}