package com.leandroid.data.network.character

import com.leandroid.data.network.service.CharacterService
import com.leandroid.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class CharacterServiceImpl(private var retrofit: Retrofit) : CharacterService {

    private val remoteCharacterService by lazy { retrofit.create(RemoteCharacterService::class.java) }

    override suspend fun getCharacter(idCharacter: Int): Character? {
        return withContext(Dispatchers.Default) {
            remoteCharacterService.load(idCharacter).execute().body()
        }
    }
}