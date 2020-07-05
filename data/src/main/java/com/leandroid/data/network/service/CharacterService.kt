package com.leandroid.data.network.service

import com.leandroid.domain.Character
import io.reactivex.Single

interface CharacterService {
    fun getCharacter(): Single<Character>
}