package com.biolumeaccessfsm.features.stockCompetetorStock.api

import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.orderList.model.NewOrderListResponseModel
import com.biolumeaccessfsm.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.biolumeaccessfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}