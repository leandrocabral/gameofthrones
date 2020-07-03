package com.leandroid.data.network.book

import com.leandroid.data.network.service.BookService
import com.leandroid.domain.Book
import io.reactivex.Single
import retrofit2.Retrofit

class BookServiceImpl(private var retrofit: Retrofit) : BookService {

    private val remoteBookService by lazy { retrofit.create(RemoteBookService::class.java) }

    override fun getBook(): Single<Book> {
        return remoteBookService.load()
    }
}