package com.biolumeaccessfsm.features.document.api

import com.biolumeaccessfsm.features.dymanicSection.api.DynamicApi
import com.biolumeaccessfsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}