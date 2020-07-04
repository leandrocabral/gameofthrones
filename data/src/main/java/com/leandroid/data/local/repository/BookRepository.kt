package com.leandroid.data.local.repository

import com.leandroid.domain.Book
import io.reactivex.Maybe

interface BookRepository {
    fun load(search: String): Maybe<List<Book>>
    fun save(book: Book)
}