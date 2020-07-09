package com.leandroid.gameofthrones.character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.domain.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel(
    application: Application,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {

    val charactersLiveData = MutableLiveData<List<Character>>()

    fun loadCharacter(){
        CoroutineScope(Dispatchers.Main).launch {
            val characters = localCharacterStore.load("")
            charactersLiveData.value = characters
        }
    }
}