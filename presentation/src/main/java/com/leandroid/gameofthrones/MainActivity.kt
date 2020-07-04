package com.leandroid.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.gameofthrones.character.CharacterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_main, CharacterFragment())
            .addToBackStack(CharacterFragment::class.java.simpleName)
            .commit()
    }
}