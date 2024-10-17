package com.breezebiolumeskincare.features.task.api

import com.breezebiolumeskincare.app.Pref
import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.task.model.AddTaskInputModel
import com.breezebiolumeskincare.features.task.model.TaskListResponseModel
import com.breezebiolumeskincare.features.timesheet.api.TimeSheetApi
import com.breezebiolumeskincare.features.timesheet.model.TimeSheetListResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 12-Aug-20.
 */
class TaskRepo(val apiService: TaskApi) {
    fun addTask(addTask: AddTaskInputModel): Observable<BaseResponse> {
        return apiService.addTask(addTask)
    }

    fun editTask(addTask: AddTaskInputModel): Observable<BaseResponse> {
        return apiService.editTask(addTask)
    }

    fun updateStatus(id: String, isCompleted: Boolean): Observable<BaseResponse> {
        return apiService.updateStatus(Pref.session_token!!, Pref.user_id!!, id, isCompleted)
    }

    fun deleteTask(id: String): Observable<BaseResponse> {
        return apiService.deleteTask(Pref.session_token!!, Pref.user_id!!, id)
    }

    fun taskList(): Observable<TaskListResponseModel> {
        return apiService.taskList(Pref.session_token!!, Pref.user_id!!)
    }
}