package com.leandroid.data.network.book

import com.leandroid.data.network.service.BookService
import com.leandroid.domain.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class BookServiceImpl(private var retrofit: Retrofit) : BookService {

    private val remoteBookService by lazy { retrofit.create(RemoteBookService::class.java) }

    override suspend fun getBook(): List<Book>? {
        return withContext(Dispatchers.Default) {
            remoteBookService.load().execute().body()
        }
    }
}