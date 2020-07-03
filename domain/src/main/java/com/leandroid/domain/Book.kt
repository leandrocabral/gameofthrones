package com.leandroid.domain

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Book(
    @field:PrimaryKey
    var id: Int? = null,
    var url: String? = null,
    var name: String? = null,
    var authors: RealmList<String>? = null,
    var numberOfPages: Int? = null,
    var publisher: String? = null,
    var country: String? = null,
    var mediaType: String? = null,
    var released: String? = null,
    var characters: RealmList<String>? = null,
    var povCharacters: RealmList<String>? = null
) : RealmObject()