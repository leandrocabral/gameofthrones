package com.leandroid.data.local.repository

import io.reactivex.Maybe
import com.leandroid.domain.Character

interface CharacterRespository {
    fun load(search: String): Maybe<List<Character>>
    fun save(character: Character)
}