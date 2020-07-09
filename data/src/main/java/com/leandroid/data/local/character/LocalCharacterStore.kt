package com.leandroid.data.local.character

import android.content.Context
import com.leandroid.data.local.AppDatabase
import com.leandroid.data.local.repository.CharacterRespository
import com.leandroid.domain.Character
import io.realm.Realm

class LocalCharacterStore(var context: Context, var appDatabase: AppDatabase) :
    CharacterRespository {
    override suspend fun load(search: String): List<Character> {
        val realm: Realm = Realm.getDefaultInstance()
        var realmObject = realm.where(Character::class.java)
            .distinct("name")
            .findAll()

        var list: List<Character> = listOf()
        return realmObject.subList(0, realmObject.size)
    }

    override suspend fun save(character: Character?) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val realObject = realm.createObject(Character::class.java)
        realObject.url = character?.url
        realObject.name = character?.name
        realObject.gender = character?.gender
        realObject.culture = character?.culture
        realObject.born = character?.born
        realObject.died = character?.died
        realObject.titles = character?.titles
        realObject.aliases = character?.aliases
        realObject.father = character?.father
        realObject.mother = character?.mother
        realObject.spouse = character?.spouse
        realObject.allegiances = character?.allegiances
        realObject.books = character?.books
        realObject.povBooks = character?.povBooks
        realObject.tvSeries = character?.tvSeries
        realObject.playedBy = character?.playedBy
        realm.commitTransaction()
    }
}