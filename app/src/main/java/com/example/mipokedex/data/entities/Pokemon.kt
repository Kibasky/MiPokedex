package com.example.mipokedex.data.entities

import android.media.Image
import com.google.gson.annotations.SerializedName


class Pokemon (
    val id: Int?,
    val number: String?,
    val name: String,
    val type: String?,
    //val image: Image,
) { }

data class PokemonResponse (
    @SerializedName("results") val results: List<Pokemon>
) { }