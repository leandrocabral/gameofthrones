package com.leandroid.gameofthrones.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.gameofthrones.R
import com.leandroid.gameofthrones.databinding.SplashActivityBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: SplashActivityBinding
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        viewModel.loadBook()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        viewModel.dataLoad
            .doOnNext {isDataLoad->
            if(isDataLoad){

            }
        }
    }
}