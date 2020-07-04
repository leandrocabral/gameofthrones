package com.leandroid.data.network.book

import com.leandroid.domain.Book
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteBookService {
    @GET("books")
    fun load(): Single<List<Book>>
}