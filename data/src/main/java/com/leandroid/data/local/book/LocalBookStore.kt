package com.leandroid.data.local.book

import android.content.Context
import com.leandroid.data.local.AppDatabase
import com.leandroid.data.local.repository.BookRepository
import com.leandroid.domain.Book
import io.reactivex.Maybe
import io.realm.Realm

class LocalBookStore(var context: Context, var appDatabase: AppDatabase) : BookRepository {
    override fun load(): Maybe<List<Book>> {
        val realm: Realm = Realm.getDefaultInstance()
        val realmObject = realm.where(Book::class.java)
            .beginGroup()
            .equalTo("name", "")
            .or()
            .contains("name", "")
            .endGroup()
            .findAll()

        val list: List<Book> = realmObject.subList(0, realmObject.size)
        return Maybe.just(list)
    }

    override fun save(books: List<Book>) {
        val realm: Realm = Realm.getDefaultInstance()
        for(book in books){
            realm.beginTransaction()
            val realObject = realm.createObject(Book::class.java)
            realObject.name = book.name
            realm.commitTransaction()
        }
    }
}