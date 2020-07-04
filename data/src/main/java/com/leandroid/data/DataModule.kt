package com.leandroid.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.leandroid.data.local.AppDatabase
import com.leandroid.data.local.book.LocalBookStore
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.data.network.InterceptorFactory
import com.leandroid.data.network.OkHttpFactory
import com.leandroid.data.network.RetrofitFactory
import com.leandroid.data.network.book.BookServiceImpl
import com.leandroid.data.network.service.BookService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


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

    single<Converter.Factory> {
        val objectMapper = jacksonObjectMapper()
        objectMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)


        val defaultDateFormat = androidContext().getString(R.string.DEFAULT_DATE_FORMAT)
        objectMapper.dateFormat = SimpleDateFormat(defaultDateFormat, Locale.US)

        objectMapper.registerModule(ThreeTenModule())

        JacksonConverterFactory.create(objectMapper)
    }

    single<AppDatabase> {
        AppDatabase(androidContext())
    }

    //region Book
    single<BookService> {
        BookServiceImpl(get())
    }

    single<BookRepository> {
        LocalBookStore(androidContext(),get())
    }

}