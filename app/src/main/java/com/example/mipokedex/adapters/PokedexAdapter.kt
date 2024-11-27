package com.example.mipokedex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mipokedex.data.entities.Pokemon
import com.example.mipokedex.databinding.ItemPokedexBinding

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

    fun render(pokemon: Pokemon) {
        // estos datos se pueden hardcodear como = "String"
        binding.numberPokemon.text = pokemon.number
        binding.namePokemon.text = pokemon.name
        binding.typePokemon.text = pokemon.type
        //Picasso.get().load(superhero.image.url).into(binding.avatarImageView)
    }
}