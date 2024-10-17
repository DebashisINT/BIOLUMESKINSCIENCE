package com.breezebiolumeskincare.features.newcollectionreport

import com.breezebiolumeskincare.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}