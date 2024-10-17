package com.breezebiolumeskincare.features.survey.api

import com.breezebiolumeskincare.features.photoReg.api.GetUserListPhotoRegApi
import com.breezebiolumeskincare.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}