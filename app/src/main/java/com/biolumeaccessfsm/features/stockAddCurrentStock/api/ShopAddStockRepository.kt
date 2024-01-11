package com.biolumeaccessfsm.features.stockAddCurrentStock.api

import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.location.model.ShopRevisitStatusRequest
import com.biolumeaccessfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.biolumeaccessfsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.biolumeaccessfsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.biolumeaccessfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}