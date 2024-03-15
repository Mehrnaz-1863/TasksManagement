package com.example.tasksmanagement.mvp.ext

import com.example.tasksmanagement.db.model.TaskEntity

interface OnBindData {

    fun saveData(taskEntity: TaskEntity){}
    fun editData(taskEntity: TaskEntity){}
    fun deleteData(taskEntity: TaskEntity){}
    fun getData(taskEntity: List<TaskEntity>){}
    fun requestData(state:Boolean){}

}