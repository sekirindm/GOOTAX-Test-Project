package com.example.gootaxtestproject.data.network.model

import com.google.gson.annotations.SerializedName

data class SuggestionResponse(
    val suggestions: List<Suggestion>
)

data class Suggestion(
    @SerializedName("value")
    val value: String,
    @SerializedName("city")
    val data: AddressData?
)

data class AddressData(
    val street: String?,
    val house: String?
)
