package com.leandroid.data.local.book

import android.content.Context
import com.leandroid.data.local.AppDatabase
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.domain.Book
import io.realm.Realm

class LocalBookStore(var context: Context, var appDatabase: AppDatabase) : BookRepository {
    override suspend fun load(): List<Book> {
        val realm: Realm = Realm.getDefaultInstance()
        val realmObject = realm.where(Book::class.java)
            .findAll()
        return realmObject.subList(0, realmObject.size)
    }

    override suspend fun save(books: List<Book>?) {
        val realm: Realm = Realm.getDefaultInstance()
        for(book in books!!){
            realm.beginTransaction()
            val realObject = realm.createObject(Book::class.java)
            realObject.name = book.name
            realm.commitTransaction()
        }
    }
}