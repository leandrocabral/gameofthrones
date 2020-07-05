package com.leandroid.gameofthrones.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.data.network.service.BookService
import com.leandroid.data.network.service.CharacterService
import com.leandroid.domain.Book
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

class SplashViewModel(
    application: Application,
    private var remoteBookService: BookService,
    private var localBookStore: BookRepository,
    private var remoteCharacterService: CharacterService,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {

    private val books = MutableLiveData<List<Book>>()
    val dataLoad: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun loadBook(): Single<List<Book>> {
        return remoteBookService.getBook()
            .flatMap { booksRemote ->
                localBookStore.load()
                    .doOnSuccess { booksLocal ->
                        if (booksLocal.isEmpty()) {
                            localBookStore.save(booksRemote)
                        }
                        books.apply { booksRemote }
                    }.subscribe()
                Single.just(booksRemote)
            }
    }

    fun loadCharacter(): Single<Boolean> {
        for (book in books.value!!) {
            dataLoad.onNext(true)
        }
        return Single.just(true)
    }
}