package com.example.mipokedex.data.entities

import com.example.mipokedex.R
import com.google.gson.annotations.SerializedName


data class PokemonResponse (
    @SerializedName("results") val results: List<Pokemon>,
    //val stats: List<Stats>

) { }


// ponemos "?" para que no falle cuando no le pasemos ese valor
class Pokemon (
    @SerializedName("id") val number: String?,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites?,
    val stats: List<Stats>,
    @SerializedName("types") val types: List<Type>?,
) {
    fun getMainType(): TypeName {
        return types!![0].type
    }

    fun getSubType(): TypeName? {
        if (types!!.size > 1) {
            return types[1].type
        } else {
            return null
        }
    }

    companion object {
        fun getSpriteType(type: TypeName): Int {
            when(type.name) {
                "normal" -> return R.drawable.ic_01_normal
                "fighting" -> return R.drawable.ic_02_fighting
                "flying" -> return R.drawable.ic_03_flying
                "poison" -> return R.drawable.ic_04_poison
                "ground" -> return R.drawable.ic_05_ground
                "rock" -> return R.drawable.ic_06_rock
                "bug" -> return R.drawable.ic_07_bug
                "ghost" -> return R.drawable.ic_08_ghost
                "steel" -> return R.drawable.ic_09_steel
                "fire" -> return R.drawable.ic_10_fire
                "water" -> return R.drawable.ic_11_water
                "grass" -> return R.drawable.ic_12_grass
                "electric" -> return R.drawable.ic_13_electric
                "psychic" -> return R.drawable.ic_14_psychic
                "ice" -> return R.drawable.ic_15_ice
                "dragon" -> return R.drawable.ic_16_dragon
                "dark" -> return R.drawable.ic_17_dark
                "fairy" -> return R.drawable.ic_18_fairy

                else -> return 0
            }
        }
    }
}

data class PokemonStats (
    val stats: List<Stats>
    //@SerializedName("type") val type: String?,
) { }

class Stats (
    @SerializedName("id") val number: String?,
) { }

class Type (
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: TypeName,
) { }

class TypeName (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) { }


class Sprites (
    @SerializedName("front_default") val frontDefault: String,
) { }


