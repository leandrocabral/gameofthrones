package com.leandroid.data.network.character

import com.leandroid.domain.Character
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteCharacterService {
    @GET("characters")
    fun load(): Single<Character>
}