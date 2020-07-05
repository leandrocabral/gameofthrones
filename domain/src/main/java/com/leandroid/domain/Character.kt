package com.leandroid.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@JsonIgnoreProperties(ignoreUnknown = true)
@RealmClass
open class Character(
    var name: String? = null
) : RealmObject()