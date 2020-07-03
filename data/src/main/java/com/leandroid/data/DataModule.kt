package com.leandroid.data

import com.leandroid.data.network.InterceptorFactory
import com.leandroid.data.network.OkHttpFactory
import com.leandroid.data.network.RetrofitFactory
import com.leandroid.data.network.book.BookServiceImpl
import com.leandroid.data.network.service.BookService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


val dataModule = module {

    //region Network
    single<Retrofit> {
        RetrofitFactory().getRetrofitInstance(androidContext(), get(), get(), get())
    }

    single {
        OkHttpFactory().getOkHttpInstance(get())
    }

    single {
        InterceptorFactory()
    }

    single {
        RxJava2CallAdapterFactory.create()
    }

    //region Book
    single<BookService> {
        BookServiceImpl(get())
    }

}