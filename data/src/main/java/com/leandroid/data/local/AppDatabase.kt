package com.leandroid.data.local

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class AppDatabase(context: Context) {
    init {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .name("default.realm")
            .build()
        Realm.setDefaultConfiguration(config)
    }
}