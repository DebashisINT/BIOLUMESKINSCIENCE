package com.breezebiolumeskincare.features.nearbyuserlist.api

import com.breezebiolumeskincare.app.Pref
import com.breezebiolumeskincare.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezebiolumeskincare.features.newcollection.model.NewCollectionListResponseModel
import com.breezebiolumeskincare.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}