package com.example.mipokedex.data.services


import com.example.mipokedex.data.entities.Pokemon
import com.example.mipokedex.data.entities.PokemonResponse
import com.example.mipokedex.data.entities.PokemonStats
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexService {
    @GET("pokemon?limit=100000&offset=0")
    suspend fun getAllPokemon() : PokemonResponse

/*    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") query: String) : Pokemon*/

    @GET("pokemon/{name}")
    suspend fun getPokemonStats() : PokemonStats

}