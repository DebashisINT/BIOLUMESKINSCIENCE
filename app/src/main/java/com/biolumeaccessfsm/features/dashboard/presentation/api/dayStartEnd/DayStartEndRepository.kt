package com.biolumeaccessfsm.features.dashboard.presentation.api.dayStartEnd

import com.biolumeaccessfsm.app.Pref
import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.dashboard.presentation.model.DaystartDayendRequest
import com.biolumeaccessfsm.features.dashboard.presentation.model.StatusDayStartEnd
import com.biolumeaccessfsm.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.biolumeaccessfsm.features.stockCompetetorStock.api.AddCompStockApi
import io.reactivex.Observable

class DayStartEndRepository (val apiService: DayStartEndApi){
    fun dayStart(daystartDayendRequest: DaystartDayendRequest): Observable<BaseResponse> {
        return apiService.submitDayStartEnd(daystartDayendRequest)
    }

    fun dayStartEndStatus(date:String): Observable<StatusDayStartEnd> {
        return apiService.statusDayStartEnd(Pref.session_token!!, Pref.user_id!!,date)
    }

    fun daystartendDelete(sessionToken:String,usrID:String,date:String,dayStDel:String,dayEndDel:String): Observable<BaseResponse> {
        return apiService.submitDayStartEndDelApi(sessionToken,usrID,date,dayStDel,dayEndDel)
    }


}