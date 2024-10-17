package com.breezebiolumeskincare.features.activities.api

import com.breezebiolumeskincare.features.member.api.TeamApi
import com.breezebiolumeskincare.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}