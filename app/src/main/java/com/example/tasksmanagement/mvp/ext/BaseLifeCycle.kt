package com.example.tasksmanagement.mvp.ext

interface BaseLifeCycle {
    fun onCreate() {}

    fun onDestroy() {}

    fun onStop() {}
}