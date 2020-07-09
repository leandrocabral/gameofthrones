package com.leandroid.data.local.repository

import com.leandroid.domain.Book
import io.reactivex.Maybe

interface BookRepository {
    suspend fun load(): List<Book>
    suspend fun save(books: List<Book>?)
}