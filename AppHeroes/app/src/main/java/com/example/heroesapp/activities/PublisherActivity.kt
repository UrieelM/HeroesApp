package com.example.heroesapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp.MainActivity
import com.example.heroesapp.R
import com.example.heroesapp.models.CharacterItem

/**
 * PublisherActivity permite al usuario cerrar sesión y navegar a HeroesActivity mostrando personajes de DC o Marvel.
 */
class PublisherActivity : AppCompatActivity() {

    private lateinit var logoutBtn: ImageView
    private lateinit var dcBtn: ImageButton
    private lateinit var marvelBtn: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.publisher_activity)

        // Inicialización de elementos de vista
        logoutBtn = findViewById(R.id.logoutBtn)
        dcBtn = findViewById(R.id.dc)
        marvelBtn = findViewById(R.id.marvel)

        // Manejo del botón de cerrar sesión
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        logoutBtn.setOnClickListener {
            Log.i("LOGOUT", "LOG OUT...")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@PublisherActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Manejo del botón de personajes de DC
        dcBtn.setOnClickListener {
            val dcCharacters = CharacterItem.characters.filter { it.id in 11..20 }
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(dcCharacters))
            intent.putExtra("COLOR", "#000000")
            intent.putExtra("IMAGE_RES", R.drawable.dclogo)

            startActivity(intent)
        }

        // Manejo del botón de personajes de Marvel
        marvelBtn.setOnClickListener {
            val marvelCharacters = CharacterItem.characters.filter { it.id in 1..10 }
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(marvelCharacters))
            intent.putExtra("COLOR", "#000000")
            intent.putExtra("IMAGE_RES", R.drawable.marvellogo)

            startActivity(intent)
        }
    }
}