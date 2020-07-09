package com.leandroid.data.local.repository

import com.leandroid.domain.Book

interface BookRepository {
    suspend fun load(): List<Book>
    suspend fun save(books: List<Book>?)
}