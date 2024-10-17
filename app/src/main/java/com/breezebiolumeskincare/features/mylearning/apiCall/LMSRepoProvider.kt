package com.breezebiolumeskincare.features.mylearning.apiCall

import com.breezebiolumeskincare.features.login.api.opportunity.OpportunityListApi
import com.breezebiolumeskincare.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}