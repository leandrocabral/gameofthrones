package com.leandroid.domain

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Character(
    var name: String? = null
) : RealmObject()