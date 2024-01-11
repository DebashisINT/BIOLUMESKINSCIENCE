package com.biolumeaccessfsm.features.photoReg.present

import com.biolumeaccessfsm.app.domain.ProspectEntity
import com.biolumeaccessfsm.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}