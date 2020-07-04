package com.leandroid.gameofthrones.character

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.data.network.service.BookService
import com.leandroid.domain.Book
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(
    application: Application,
    private var remoteBookService: BookService,
    private var localBookStore: BookRepository
) : AndroidViewModel(application) {

    private val character = MutableLiveData<List<Character>>()

    fun getBook(): Single<List<Book>> {

        localBookStore.load("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {books->
                Log.i("bookLocal",books.toString())
            }.subscribe()

        localBookStore.save(Book(name="Teste"))

        return remoteBookService.getBook()
    }
}