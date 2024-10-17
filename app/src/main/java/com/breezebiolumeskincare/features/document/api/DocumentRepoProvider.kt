package com.breezebiolumeskincare.features.document.api

import com.breezebiolumeskincare.features.dymanicSection.api.DynamicApi
import com.breezebiolumeskincare.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}