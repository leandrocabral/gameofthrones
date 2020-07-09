package com.leandroid.gameofthrones.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.leandroid.gameofthrones.MainActivity
import com.leandroid.gameofthrones.R
import com.leandroid.gameofthrones.databinding.SplashActivityBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: SplashActivityBinding
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        viewModel.syncdData()

        viewModel.dataSyncLiveData.observe(this, Observer { isDataLoad ->
            if (isDataLoad) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}
