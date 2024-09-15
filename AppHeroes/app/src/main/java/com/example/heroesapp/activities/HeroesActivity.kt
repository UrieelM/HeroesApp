package com.example.heroesapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.adapters.CharacterItemAdapter
import com.example.heroesapp.models.CharacterItem

/**
 * HeroesActivity muestra una lista de personajes en un RecyclerView y permite navegar de vuelta a PublisherActivity.
 */
class HeroesActivity : AppCompatActivity() {

    private lateinit var backHeroes: ImageView
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var publisherLogo: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_heroes)

        // Configuración del fondo de la actividad basado en el color recibido
        val colorHex = intent.getStringExtra("COLOR")
        colorHex?.let {
            val color = Color.parseColor(it)
            window.decorView.setBackgroundColor(color)
        }

        // Configuración del logo del publicador
        val imageRes = intent.getIntExtra("IMAGE_RES", -1)
        publisherLogo = findViewById(R.id.publisherlogo)
        if (imageRes != -1) {
            publisherLogo.setImageResource(imageRes)
        }

        // Configuración del RecyclerView para mostrar la lista de personajes
        val charactersList = intent.getParcelableArrayListExtra<CharacterItem>("CHARACTERS_LIST")
        backHeroes = findViewById(R.id.back_heroes)
        backHeroes.setOnClickListener {
            val intent = Intent(this@HeroesActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }

        itemRecyclerView = findViewById(R.id.heroes_list)
        itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Establecer el adaptador para el RecyclerView si la lista de personajes no es nula
        charactersList?.let {
            itemRecyclerView.adapter = CharacterItemAdapter(it)
        }
    }
}