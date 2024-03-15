package com.example.tasksmanagement.ui.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.tasksmanagement.R
import com.example.tasksmanagement.databinding.ActivityMainSplashBinding

class MainActivitySplash : AppCompatActivity() {
    private lateinit var binding: ActivityMainSplashBinding
    private lateinit var media: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSplashBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.txt1Name.animation = anim(R.anim.move_start)
        binding.txt2Name.animation = anim(R.anim.move_end)
        binding.image1.animation = anim(R.anim.zoom_in)
        binding.image2.animation = anim(R.anim.move_bottom)

//        intent=Intent(this@MainActivitySplash,MainActivity::class.java)
//        binding.txt2Name.setOnClickListener {
//            startActivity(intent)
//        }

//        media=MediaPlayer.create(this,R.raw.music)
//        media.start()

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivitySplash, MainActivity::class.java)
            startActivity(intent)

            finish()
        }, 5000)

    }
    private fun anim(animation: Int) = AnimationUtils.loadAnimation(this, animation)
//    override fun onStop() {
//        if (media.isPlaying)
//            media.stop()
//        super.onStop()
//    }

}




