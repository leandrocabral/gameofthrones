package com.leandroid.data.network.character

import com.leandroid.domain.Character
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteCharacterService {
    @GET("characters/{id}")
    fun load(@Path("id") idCharacter: Int): Single<Character>
}