package com.example.andesiaapps.data.api

import com.example.andesiaapps.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel


}