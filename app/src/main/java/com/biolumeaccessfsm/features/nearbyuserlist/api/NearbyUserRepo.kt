package com.biolumeaccessfsm.features.nearbyuserlist.api

import com.biolumeaccessfsm.app.Pref
import com.biolumeaccessfsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.biolumeaccessfsm.features.newcollection.model.NewCollectionListResponseModel
import com.biolumeaccessfsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}