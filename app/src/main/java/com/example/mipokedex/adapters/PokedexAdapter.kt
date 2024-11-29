package com.example.mipokedex.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mipokedex.R
import com.example.mipokedex.data.entities.Pokemon
import com.example.mipokedex.data.providers.RetrofitProvider
import com.example.mipokedex.databinding.ItemPokedexBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokedexAdapter (var items: List<Pokemon>, val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokedexBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.render(items[position])
        val pokemon = items[position]
        holder.render(pokemon)
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    // override fun getItemCount(): Int = items.size
    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<Pokemon>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class ViewHolder(val binding: ItemPokedexBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var pokemon: Pokemon

    fun render(pokemon: Pokemon) {
        if (pokemon.number == null) {
            binding.namePokemon.text = pokemon.name
            binding.numberPokemon.text = (adapterPosition + 1).toString()
            getPokemonStats(pokemon.name)
        } else {
            Picasso.get().load(pokemon.sprites?.frontDefault).into(binding.imagePokemon)
            val mainTypeIcon = Pokemon.getSpriteType(pokemon.getMainType())
            binding.typeSlot1.setImageResource(mainTypeIcon)
            if (pokemon.getSubType() != null) {
                val subTypeIcon = Pokemon.getSpriteType(pokemon.getSubType()!!)
                binding.typeSlot2.setImageResource(subTypeIcon)
            } else {
                binding.typeSlot2.setImageDrawable(null)
            }
            //binding.typePokemon.text = types
        }
        // estos datos se pueden hardcodear como = "String"

        //binding.numberPokemon.text = pokemon.number
        //binding.typePokemon.text = pokemon.type
        //Picasso.get().load(superhero.image.url).into(binding.avatarImageView)
    }


    fun getPokemonStats(pokemonName: String) {
        val service = RetrofitProvider.getRetrofit()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                pokemon = service.getPokemonStats(pokemonName)

                CoroutineScope(Dispatchers.Main).launch {
                    render(pokemon)
                }
            } catch (e: Exception) {
                Log.e("API", e.stackTraceToString())
            }
        }
    }
}