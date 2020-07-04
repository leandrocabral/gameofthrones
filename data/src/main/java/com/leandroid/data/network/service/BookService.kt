package com.leandroid.data.network.service

import com.leandroid.domain.Book
import io.reactivex.Single

interface BookService {
    fun getBook(): Single<List<Book>>
}