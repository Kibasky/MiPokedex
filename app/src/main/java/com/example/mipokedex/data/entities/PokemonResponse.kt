package com.example.mipokedex.data.entities

import com.google.gson.annotations.SerializedName


data class PokemonResponse (
    @SerializedName("results") val results: List<Pokemon>,
    //val stats: List<Stats>

) { }


// ponemos "?" para que no falle cuando no le pasemos ese valor
class Pokemon (
    @SerializedName("name") val name: String?,
    val stats: List<Stats>,
    //@SerializedName("type") val type: String?,
) { }

data class PokemonStats (
    val stats: List<Stats>
    //@SerializedName("type") val type: String?,
) { }

class Stats (
    @SerializedName("id") val number: String?,
    @SerializedName("types") val types: Types?,
    @SerializedName("sprites") val sprites: Sprites?,
) { }

class Types (
    @SerializedName("type") val types: TipesName?,
) { }

class TipesName (
    @SerializedName("name") val types: String?,
) { }


class Sprites (
    //@SerializedName("front_default") val frontDefault: url?,
) { }


