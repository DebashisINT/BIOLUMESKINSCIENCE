package com.biolumeaccessfsm.features.task.api

import com.biolumeaccessfsm.features.timesheet.api.TimeSheetApi
import com.biolumeaccessfsm.features.timesheet.api.TimeSheetRepo

/**
 * Created by Saikat on 12-Aug-20.
 */
object TaskRepoProvider {
    fun taskRepoProvider(): TaskRepo {
        return TaskRepo(TaskApi.create())
    }
}