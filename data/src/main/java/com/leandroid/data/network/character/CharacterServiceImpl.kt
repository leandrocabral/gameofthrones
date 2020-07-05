package com.leandroid.data.network.character

import com.leandroid.data.network.service.CharacterService
import com.leandroid.domain.Character
import io.reactivex.Single
import retrofit2.Retrofit

class CharacterServiceImpl(private var retrofit: Retrofit) : CharacterService {

    private val remoteCharacterService by lazy { retrofit.create(RemoteCharacterService::class.java) }

    override fun getCharacter(): Single<Character> {
        return remoteCharacterService.load()
    }
}