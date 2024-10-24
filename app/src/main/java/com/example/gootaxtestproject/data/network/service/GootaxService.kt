package com.example.gootaxtestproject.data.network.service

import com.example.gootaxtestproject.data.network.model.SuggestionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GootaxService {
    @GET("address")
    suspend fun getAddressSuggestions(
        @Query("query") query: String,
        @Header("Authorization") token: String
    ): Response<SuggestionResponse>
}