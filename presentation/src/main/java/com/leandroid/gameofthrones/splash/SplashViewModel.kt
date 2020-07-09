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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel(
    application: Application,
    private var remoteBookService: BookService,
    private var localBookStore: BookRepository,
    private var remoteCharacterService: CharacterService,
    private var localCharacterStore: CharacterRespository
) : AndroidViewModel(application) {

    val booksLiveData = MutableLiveData<List<Book>>()
    val dataSyncLiveData = MutableLiveData<Boolean>()

    fun syncdData() {
        CoroutineScope(Dispatchers.Main).launch {
            val bookRemote = withContext(Dispatchers.Default) {
                remoteBookService.getBook()
            }
            booksLiveData.value = bookRemote

            val booksLocal =  withContext(Dispatchers.Default) {
                localBookStore.load()
            }

            if(booksLocal.isEmpty()){
                syncCharacter(bookRemote)
            }else{
                dataSyncLiveData.value = true
            }
        }
    }

    private fun syncCharacter(books: List<Book>?) {
        CoroutineScope(Dispatchers.Main).launch {
            localBookStore.save(books)

            for ((indexBook, book) in books?.withIndex()!!) {
                for (character in book.povCharacters) {
                    if (book.povCharacters.isNotEmpty()) {
                        val characterRemote = withContext(Dispatchers.Default) {
                            remoteCharacterService.getCharacter(character.getIdCharacter())
                        }
                        localCharacterStore.save(characterRemote)
                    }
                }
                if (book.isLastBook(indexBook, books)) {
                    dataSyncLiveData.value = true
                }
            }
        }
    }
}