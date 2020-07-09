package com.leandroid.data.network.service

import com.leandroid.domain.Character
import io.reactivex.Single

interface CharacterService {
    suspend fun getCharacter(idCharacter: Int): Character?
}