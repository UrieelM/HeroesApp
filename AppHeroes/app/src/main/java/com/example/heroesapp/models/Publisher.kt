package com.example.heroesapp.models

/**
 * Representa un editor o publicador con información necesaria para mostrar en la aplicación.
 *
 * @property id Identificador único del editor.
 * @property name Nombre del editor.
 * @property image URL de la imagen del editor.
 */
data class Publisher(
    val id: Int,
    val name: String,
    val image: String
) {
    /**
     * Lista estática de editores predefinidos.
     */
    companion object {
        val publishers = mutableListOf(
            Publisher(1, "Dc", "https://i.imgur.com/1lubpNz.png"),
            Publisher(2, "Marvel", "https://i.imgur.com/qWHrIPz.png")
        )
    }
}