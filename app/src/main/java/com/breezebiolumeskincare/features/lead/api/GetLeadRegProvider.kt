package com.breezebiolumeskincare.features.lead.api

import com.breezebiolumeskincare.features.NewQuotation.api.GetQuotListRegRepository
import com.breezebiolumeskincare.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}