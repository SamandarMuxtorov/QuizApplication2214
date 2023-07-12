package com.example.quizapplication2214.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapplication2214.MainActivity
import com.example.quizapplication2214.R
import com.example.quizapplication2214.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animationView.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 4000)
    }
}