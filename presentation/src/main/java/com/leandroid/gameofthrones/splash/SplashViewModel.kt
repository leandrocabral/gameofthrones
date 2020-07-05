package com.leandroid.gameofthrones.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.data.network.service.BookService
import com.leandroid.data.network.service.CharacterService
import com.leandroid.domain.Book
import com.leandroid.gameofthrones.extension.getIdCharacter
import com.leandroid.gameofthrones.extension.isLastBook
import io.reactivex.Single

class SplashViewModel(
    application: Application,
    private var remoteBookService: BookService,
    private var localBookStore: BookRepository,
    private var remoteCharacterService: CharacterService,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {

    val books = MutableLiveData<List<Book>>()
    val dataLoad = MutableLiveData<Boolean>()

    fun loadData(): Single<Boolean> {
        return remoteBookService.getBook()
            .flatMap { booksRemote ->
                localBookStore.load()
                    .doOnSuccess { booksLocal ->
                        if (booksLocal.isEmpty()) {
                            syncCharacter(booksRemote)
                        } else {
                            dataLoad.postValue(true)
                        }
                        books.postValue(booksRemote)
                    }.subscribe()
                Single.just(true)
            }
    }

    private fun syncCharacter(books: List<Book>) {
        localBookStore.save(books)
        for ((indexBook, book) in books.withIndex()) {
            for (character in book.povCharacters!!) {
                if (book.povCharacters!!.isNotEmpty()) {
                    remoteCharacterService.getCharacter(character.getIdCharacter())
                        .doOnSuccess { character ->
                            localCharacterStore.save(character)
                        }.doOnError { throwable ->
                            throwable.stackTrace
                        }.subscribe()
                }
            }
            if (book.isLastBook(indexBook, books)) {
                dataLoad.postValue(true)
            }
        }
    }
}