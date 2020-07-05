package com.leandroid.data.local.repository

import com.leandroid.domain.Book
import io.reactivex.Maybe

interface BookRepository {
    fun load(): Maybe<List<Book>>
    fun save(books: List<Book>)
}