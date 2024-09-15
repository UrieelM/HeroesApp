package com.example.heroesapp.models

/**
 * Representa un usuario con credenciales para autenticación.
 *
 * @property email Dirección de correo electrónico del usuario.
 * @property password Contraseña del usuario.
 */
data class User(
    val email: String,
    val password: String
) {
    /**
     * Lista estática de usuarios predefinidos para propósitos de autenticación.
     */
    companion object {
        val users = listOf(
            User("uriel@gmail.com", "hola1234"),
            User("mendoza@gmail.com", "hola1234"),
            User("rodriguez@gmail.com", "hola1234")
        )
    }
}