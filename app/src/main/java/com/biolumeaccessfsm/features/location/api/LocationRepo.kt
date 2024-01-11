package com.biolumeaccessfsm.features.location.api

import com.biolumeaccessfsm.app.Pref
import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.location.model.AppInfoInputModel
import com.biolumeaccessfsm.features.location.model.AppInfoResponseModel
import com.biolumeaccessfsm.features.location.model.GpsNetInputModel
import com.biolumeaccessfsm.features.location.model.ShopDurationRequest
import com.biolumeaccessfsm.features.location.shopdurationapi.ShopDurationApi
import io.reactivex.Observable

/**
 * Created by Saikat on 17-Aug-20.
 */
class LocationRepo(val apiService: LocationApi) {
    fun appInfo(appInfo: AppInfoInputModel?): Observable<BaseResponse> {
        return apiService.submitAppInfo(appInfo)
    }

    fun getAppInfo(): Observable<AppInfoResponseModel> {
        return apiService.getAppInfo(Pref.session_token!!, Pref.user_id!!)
    }

    fun gpsNetInfo(appInfo: GpsNetInputModel?): Observable<BaseResponse> {
        return apiService.submitGpsNetInfo(appInfo)
    }
}