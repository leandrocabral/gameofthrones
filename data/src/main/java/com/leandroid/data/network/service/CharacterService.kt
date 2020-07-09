package com.leandroid.data.network.service

import com.leandroid.domain.Character

interface CharacterService {
    suspend fun getCharacter(idCharacter: Int): Character?
}