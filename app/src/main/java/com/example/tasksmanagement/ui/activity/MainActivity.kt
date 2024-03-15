package com.example.tasksmanagement.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksmanagement.mvp.model.ModelMainActivity
import com.example.tasksmanagement.mvp.presenter.PresenterMainActivity
import com.example.tasksmanagement.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)

        presenter = PresenterMainActivity(view, ModelMainActivity(this))
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}