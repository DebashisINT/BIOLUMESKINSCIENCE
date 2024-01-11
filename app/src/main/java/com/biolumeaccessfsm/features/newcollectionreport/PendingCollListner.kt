package com.biolumeaccessfsm.features.newcollectionreport

import com.biolumeaccessfsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}