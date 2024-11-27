package com.example.mipokedex.data.providers

import com.example.mipokedex.data.services.PokedexService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    companion object {
        fun getRetrofit() : PokedexService {
            //val tokenApi = "ceafbf6d4409617633ba7cb7c260e9da"

            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokedexService::class.java)
            //return PokedexService
        }
    }
}