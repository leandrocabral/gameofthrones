package com.leandroid.data.network.book

import com.leandroid.domain.Book
import retrofit2.Call
import retrofit2.http.GET

interface RemoteBookService {
    @GET("books")
    fun load(): Call<List<Book>>
}