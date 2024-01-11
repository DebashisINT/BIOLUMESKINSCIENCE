package com.biolumeaccessfsm.features.lead.api

import com.biolumeaccessfsm.features.NewQuotation.api.GetQuotListRegRepository
import com.biolumeaccessfsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}