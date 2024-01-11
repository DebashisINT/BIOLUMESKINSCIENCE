package com.biolumeaccessfsm.features.survey.api

import com.biolumeaccessfsm.features.photoReg.api.GetUserListPhotoRegApi
import com.biolumeaccessfsm.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}