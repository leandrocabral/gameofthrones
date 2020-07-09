package com.leandroid.data.local.repository

import com.leandroid.domain.Character

interface CharacterRespository {
    suspend fun load(search: String): List<Character>
    suspend fun save(character: Character?)
}