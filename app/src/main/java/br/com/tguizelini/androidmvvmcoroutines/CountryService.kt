package br.com.tguizelini.androidmvvmcoroutines

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryService {
    private val api: CountryApi = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryApi::class.java)

    suspend fun getCountries(): Response<List<Country>> = api.all()
}