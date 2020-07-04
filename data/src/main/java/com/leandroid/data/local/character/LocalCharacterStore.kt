package com.leandroid.data.local.character

import android.content.Context
import com.leandroid.data.local.AppDatabase
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.domain.Character
import io.realm.Realm
import io.reactivex.Maybe

class LocalCharacterStore(var context: Context, var appDatabase: AppDatabase) :
    CharacterRespository {
    override fun load(search: String): Maybe<List<Character>> {
        val realm: Realm = Realm.getDefaultInstance()
        var realmObject = realm.where(Character::class.java)
            .beginGroup()
            .equalTo("name", "Peter")
            .or()
            .contains("name", "Jo")
            .endGroup()
            .findAll()

        var list: List<Character> = listOf()
        list = realmObject.subList(0, realmObject.size)

        return Maybe.just(list)
    }

    override fun save(character: Character) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val realObject = realm.createObject(Character::class.java)
        realm.commitTransaction()
    }
}