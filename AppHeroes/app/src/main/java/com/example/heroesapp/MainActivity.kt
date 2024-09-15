package com.example.heroesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp.activities.PublisherActivity
import com.example.heroesapp.models.User
import com.google.android.material.snackbar.Snackbar

/**
 * Actividad principal que maneja el inicio de sesión del usuario
 */
class MainActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if (isLogged) {
            // Si el usuario ya está autenticado, redirige a PublisherActivity
            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
        Log.i("credentials", isLogged.toString())

        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)
        loginBtn = findViewById(R.id.btnLogin)

        loginBtn.setOnClickListener { v ->
            Log.i("credentials", "Iniciando Sesión")
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Verifica si el correo o la contraseña están vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Log.i("credentials", "Email o contraseña vacíos")
                Snackbar.make(v, "El correo electrónico o la contraseña están vacíos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verifica las credenciales del usuario
            val isValidUser = User.users.any { user -> user.email == email && user.password == password }
            if (!isValidUser) {
                Log.i("credentials", "Datos incorrectos")
                Snackbar.make(v, "Datos incorrectos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Guarda el estado de autenticación y redirige a PublisherActivity
            Log.i("credentials", "Accediendo")
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}