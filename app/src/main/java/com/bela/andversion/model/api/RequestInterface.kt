package com.bela.andversion.model.api

import com.bela.andversion.model.data.Android
import io.reactivex.Single
import retrofit2.http.GET

interface RequestInterface {
    @GET("api/android")
    fun getData(): Single<List<Android>>
}