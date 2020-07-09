package com.leandroid.data.network.service

import com.leandroid.domain.Book

interface BookService {
    suspend fun getBook(): List<Book>?
}