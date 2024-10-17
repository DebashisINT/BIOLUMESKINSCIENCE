package com.breezebiolumeskincare.features.photoReg.present

import com.breezebiolumeskincare.app.domain.ProspectEntity
import com.breezebiolumeskincare.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}