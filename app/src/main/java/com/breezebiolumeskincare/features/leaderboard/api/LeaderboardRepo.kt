package com.breezebiolumeskincare.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.breezebiolumeskincare.app.FileUtils
import com.breezebiolumeskincare.app.Pref
import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.addshop.model.AddLogReqData
import com.breezebiolumeskincare.features.addshop.model.AddShopRequestData
import com.breezebiolumeskincare.features.addshop.model.AddShopResponse
import com.breezebiolumeskincare.features.addshop.model.LogFileResponse
import com.breezebiolumeskincare.features.addshop.model.UpdateAddrReq
import com.breezebiolumeskincare.features.contacts.CallHisDtls
import com.breezebiolumeskincare.features.contacts.CompanyReqData
import com.breezebiolumeskincare.features.contacts.ContactMasterRes
import com.breezebiolumeskincare.features.contacts.SourceMasterRes
import com.breezebiolumeskincare.features.contacts.StageMasterRes
import com.breezebiolumeskincare.features.contacts.StatusMasterRes
import com.breezebiolumeskincare.features.contacts.TypeMasterRes
import com.breezebiolumeskincare.features.dashboard.presentation.DashboardActivity
import com.breezebiolumeskincare.features.login.model.WhatsappApiData
import com.breezebiolumeskincare.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}