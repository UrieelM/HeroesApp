package com.example.heroesapp.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp.R
import com.squareup.picasso.Picasso

/**
 * HeroDetailActivity muestra los detalles de un héroe, incluyendo su nombre, imagen y descripción.
 * La actividad también maneja la navegación de vuelta a PublisherActivity y ajusta el fondo en función del ID del héroe.
 */
class HeroDetailActivity : AppCompatActivity() {

    private lateinit var backbtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hero_detail)

        // Inicialización del botón de retroceso
        backbtn = findViewById(R.id.back_list)
        backbtn.setOnClickListener {
            val intent = Intent(this@HeroDetailActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Obtención de datos del héroe desde el Intent
        val heroName = intent.getStringExtra("heroName")
        val heroImage = intent.getStringExtra("heroImage")
        val description = intent.getStringExtra("description")
        val heroId = intent.getIntExtra("heroId", 0)

        // Referencias a los elementos de la vista
        val heroNameTextView: TextView = findViewById(R.id.heroname)
        val heroImageView: ImageView = findViewById(R.id.cardview)
        val descriptionTextView: TextView = findViewById(R.id.descripcion)
        val scrollView: ScrollView = findViewById(R.id.detailactivity)

        // Configuración de los datos del héroe
        heroNameTextView.text = heroName
        Picasso.get().load(heroImage).into(heroImageView)
        descriptionTextView.text = description

        // Determinación del fondo basado en el ID del héroe
        val marvelWallpaper = R.drawable.wallpapermarvel
        val dcWallpaper = R.drawable.wallpaperdc
        val defaultWallpaper = R.drawable.wallpaper

        val backgroundResource = when {
            heroId in 1..10 -> marvelWallpaper
            heroId in 11..20 -> dcWallpaper
            else -> defaultWallpaper
        }

        scrollView.setBackgroundResource(backgroundResource)
    }
}