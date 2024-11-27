package com.example.mipokedex.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mipokedex.R
import com.example.mipokedex.adapters.PokedexAdapter
import com.example.mipokedex.data.entities.Pokemon
import com.example.mipokedex.databinding.ActivityListBinding
import com.example.mipokedex.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {

    lateinit var binding: ActivityListBinding

    lateinit var adapter: PokedexAdapter

    // podemos hardcodear como = listOf(Pokemon(1, "25", "Pikachu", "Eléctrico")),
    // o con listOf(Pokemon(1, "", "", "")) + render
    var pokedexList: List<Pokemon> = listOf(Pokemon(0, "03", "Charizard", "Fuego"),
                                            Pokemon(1, "25", "Pikachu", "Eléctrico"),
                                            Pokemon(2, "151", "Mew", "Psíquico"))
    /*// funcion 151 pkm
    var pokedexList: List<Pokemon> = getPlaceholderPokemons()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    adapter = PokedexAdapter(pokedexList) { position ->
        val pokedex = pokedexList[position]
        //navigateToDetail(pokedex)
    }

    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    /*// función para mostrar 151 pkm sin API
    fun getPlaceholderPokemons() : List<Pokemon> {
        val listOfPokemon = mutableListOf<Pokemon>()
        for (i in 1..151) {
            listOfPokemon.add(Pokemon(i, i.toString(), "Pokemon $i", "Type"))
        }
        return listOfPokemon
    }*/
}