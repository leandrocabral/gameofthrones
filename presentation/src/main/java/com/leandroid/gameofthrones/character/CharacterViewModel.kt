package com.leandroid.gameofthrones.character

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.data.network.service.BookService
import com.leandroid.data.network.service.CharacterService
import com.leandroid.domain.Book
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(
    application: Application,
    private var remoteCharacterService: CharacterService,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {


}