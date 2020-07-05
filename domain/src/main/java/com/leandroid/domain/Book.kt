package com.leandroid.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@JsonIgnoreProperties(ignoreUnknown = true)
@RealmClass
open class Book(
    @JsonProperty("url")
    var url: String? = null,
    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("authors")
    var authors: RealmList<String>? = null,
    @JsonProperty("numberOfPages")
    var numberOfPages: Int? = null,
    @JsonProperty("publisher")
    var publisher: String? = null,
    @JsonProperty("country")
    var country: String? = null,
    @JsonProperty("mediaType")
    var mediaType: String? = null,
    @JsonProperty("released")
    var released: String? = null,
    @JsonProperty("characters")
    var characters: RealmList<String>? = null,
    @JsonProperty("povCharacters")
    var povCharacters: RealmList<String> = RealmList<String>()
) : RealmObject()