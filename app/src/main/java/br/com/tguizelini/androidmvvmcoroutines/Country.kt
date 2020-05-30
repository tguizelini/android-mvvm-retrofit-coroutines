package br.com.tguizelini.androidmvvmcoroutines

import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("name")
    val name: String? = ""
)