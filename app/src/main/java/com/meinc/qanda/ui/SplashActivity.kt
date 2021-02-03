package com.meinc.qanda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meinc.qanda.R
import com.meinc.qanda.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}