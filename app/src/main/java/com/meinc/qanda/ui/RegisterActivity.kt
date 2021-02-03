package com.meinc.qanda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meinc.qanda.R
import com.meinc.qanda.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}