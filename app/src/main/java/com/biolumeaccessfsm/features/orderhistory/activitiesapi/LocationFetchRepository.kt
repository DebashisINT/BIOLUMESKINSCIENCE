package com.biolumeaccessfsm.features.orderhistory.activitiesapi

import com.biolumeaccessfsm.app.Pref
import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.orderhistory.model.FetchLocationRequest
import com.biolumeaccessfsm.features.orderhistory.model.FetchLocationResponse
import com.biolumeaccessfsm.features.orderhistory.model.SubmitLocationInputModel
import com.biolumeaccessfsm.features.orderhistory.model.UnknownReponseModel
import io.reactivex.Observable

/**
 * Created by Pratishruti on 30-11-2017.
 */
class LocationFetchRepository(val apiService: LocationFetchApi){
    fun fetchLocationUpdate(location: FetchLocationRequest): Observable<FetchLocationResponse> {
        return apiService.getLocationUpdates(location)
    }

    fun fetchLocationUpdate(date: String): Observable<FetchLocationResponse> {
        return apiService.getLocationUpdates(Pref.session_token!!, Pref.user_id!!, date)
    }

    fun fetchUnknownLocation(): Observable<UnknownReponseModel> {
        return apiService.getUnknownLocation(Pref.session_token!!, Pref.user_id!!)
    }

    fun submitLoc(loc: SubmitLocationInputModel): Observable<BaseResponse> {
        return apiService.submitLocation(loc)
    }
}