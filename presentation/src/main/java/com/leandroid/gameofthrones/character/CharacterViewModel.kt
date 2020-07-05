package com.leandroid.gameofthrones.character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.CharacterRespository
import io.reactivex.Maybe
import com.leandroid.domain.Character

class CharacterViewModel(
    application: Application,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {

    val characters = MutableLiveData<List<Character>>()

    fun loadCharacter(): Maybe<List<Character>>{
        return localCharacterStore.load("")
            .doOnSuccess {charactersLocal->
                characters.postValue(charactersLocal)
        }
    }

}