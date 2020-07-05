package com.leandroid.gameofthrones

import com.leandroid.gameofthrones.character.CharacterViewModel
import com.leandroid.gameofthrones.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterViewModel(androidApplication(),get(),get()) }
    viewModel { SplashViewModel(androidApplication(),get(),get(),get(),get()) }
}