package com.biolumeaccessfsm.features.photoReg.adapter

import com.biolumeaccessfsm.features.photoReg.model.ProsCustom
import com.biolumeaccessfsm.features.photoReg.model.UserListResponseModel

interface ProsListSelectionListner {
    fun getInfo(obj: ProsCustom)
}