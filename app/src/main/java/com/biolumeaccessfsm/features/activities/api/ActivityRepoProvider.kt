package com.biolumeaccessfsm.features.activities.api

import com.biolumeaccessfsm.features.member.api.TeamApi
import com.biolumeaccessfsm.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}