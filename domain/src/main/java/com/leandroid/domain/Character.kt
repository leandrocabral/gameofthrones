package com.leandroid.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@JsonIgnoreProperties(ignoreUnknown = true)
@RealmClass
open class Character(
    @JsonProperty("url")
    var url: String? = null,
    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("gender")
    var gender: String? = null,
    @JsonProperty("culture")
    var culture: String? = null,
    @JsonProperty("born")
    var born: String? = null,
    @JsonProperty("died")
    var died: String? = null,
    @JsonProperty("titles")
    var titles: RealmList<String>? = RealmList<String>(),
    @JsonProperty("aliases")
    var aliases: RealmList<String>? = RealmList<String>(),
    @JsonProperty("father")
    var father: String? = null,
    @JsonProperty("mother")
    var mother: String? = null,
    @JsonProperty("spouse")
    var spouse: String? = null,
    @JsonProperty("allegiances")
    var allegiances: RealmList<String>? = RealmList<String>(),
    @JsonProperty("books")
    var books: RealmList<String>? = RealmList<String>(),
    @JsonProperty("povBooks")
    var povBooks: RealmList<String>? = RealmList<String>(),
    @JsonProperty("tvSeries")
    var tvSeries: RealmList<String>? = RealmList<String>(),
    @JsonProperty("playedBy")
    var playedBy: RealmList<String>? = RealmList<String>()
) : RealmObject()