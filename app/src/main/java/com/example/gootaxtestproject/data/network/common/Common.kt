package com.example.gootaxtestproject.data.network.common

import com.example.gootaxtestproject.data.network.service.GootaxService
import com.example.gootaxtestproject.data.network.model.GootaxClient


object Common {
    private val BASE_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/"
    val gootaxService: GootaxService
        get() = GootaxClient.getClient(BASE_URL).create(GootaxService::class.java)
}

