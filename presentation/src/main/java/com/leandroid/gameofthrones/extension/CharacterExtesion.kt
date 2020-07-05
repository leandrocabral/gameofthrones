package com.leandroid.gameofthrones.extension

import com.leandroid.domain.Book

fun String.getIdCharacter(): Int {
    return this.substring(this.lastIndexOf('/') + 1).toInt()
}

fun Book.isLastBook(indexBook: Int,  books: List<Book>): Boolean {
    return ((indexBook +1) == books.size)
}