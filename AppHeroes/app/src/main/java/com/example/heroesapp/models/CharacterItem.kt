package com.example.heroesapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Representa un ítem de personaje con información necesaria para mostrar en la aplicación.
 *
 * @property id Identificador único del personaje.
 * @property name Nombre del personaje.
 * @property imagen URL de la imagen del personaje.
 * @property descripcion Descripción del personaje.
 */
data class CharacterItem(
    val id: Int,
    val name: String,
    val imagen: String,
    val descripcion: String
) : Parcelable {

    /**
     * Constructor para crear una instancia de CharacterItem a partir de un Parcel.
     */
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    /**
     * Escribe los datos del objeto en un Parcel.
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(imagen)
        parcel.writeString(descripcion)
    }

    /**
     * Describe el contenido del objeto Parcel.
     */
    override fun describeContents(): Int {
        return 0
    }

    /**
     * Creador para crear instancias de CharacterItem desde un Parcel.
     */
    companion object CREATOR : Parcelable.Creator<CharacterItem> {
        override fun createFromParcel(parcel: Parcel): CharacterItem {
            return CharacterItem(parcel)
        }

        override fun newArray(size: Int): Array<CharacterItem?> {
            return arrayOfNulls(size)
        }

        // Lista estática de personajes predefinidos.
        val characters = mutableListOf(
            CharacterItem(1, "Captain America", "https://i.imgur.com/w8mAEi6.jpeg", "Un soldado superserum con un fuerte sentido del deber y la justicia, conocido por su escudo indestructible y su liderazgo en los Vengadores."),
            CharacterItem(2, "Dr. Strange", "https://i.imgur.com/d2WYYH3.jpeg", "Un ex-cirujano convertido en el Hechicero Supremo, con habilidades en magia y manipulación de la realidad para proteger el multiverso."),
            CharacterItem(3, "Hulk", "https://i.imgur.com/3LEjRPU.jpeg", "Un científico que se transforma en un gigante verde de fuerza increíble cuando se enfurece, conocido por su poder destructivo y su lucha interna."),
            CharacterItem(4, "Iron Man", "https://i.imgur.com/Gzq0hqI.jpeg", "Un genio millonario con una armadura de alta tecnología que utiliza para luchar contra el crimen y las amenazas globales."),
            CharacterItem(5, "Black Panther", "https://i.imgur.com/uASdfK4.jpeg", "El rey de Wakanda, con habilidades sobrehumanas y un traje de pantera mejorado, conocido por su inteligencia, agilidad y liderazgo."),
            CharacterItem(6, "Scarlet Witch", "https://i.imgur.com/8EKP8wY.jpeg", "Una poderosa bruja con habilidades para manipular la realidad y la magia, y una conexión profunda con el caos y el poder."),
            CharacterItem(7, "Spiderman", "https://i.imgur.com/oXE5lVq.jpeg", "Un adolescente con habilidades arácnidas que usa para luchar contra el crimen en Nueva York, conocido por su agilidad, sentido arácnido y su habilidad para trepar muros."),
            CharacterItem(8, "Thor", "https://i.imgur.com/qNZUIB9.jpeg", "El dios del trueno de Asgard con una fuerza inmensa, capaz de controlar el rayo y empuñar el martillo Mjölnir."),
            CharacterItem(9, "War Machine", "https://i.imgur.com/b6HtsXQ.jpeg", "Un compañero de Iron Man con una armadura de alta tecnología equipada con armamento avanzado y habilidades de combate."),
            CharacterItem(10, "Wolverine", "https://i.imgur.com/o3t03rZ.jpeg", "Un mutante con garras de adamantium, regeneración rápida y una personalidad feroz, conocido por su habilidad en combate y su pasado tormentoso."),
            CharacterItem(11, "Aquaman", "https://i.imgur.com/kfUDnD0.jpeg", "El rey de Atlantis con habilidades acuáticas, fuerza sobrehumana y la capacidad de comunicarse con la vida marina."),
            CharacterItem(12, "Batman", "https://i.imgur.com/vFja4C7.jpeg", "Un vigilante enmascarado de Gotham con habilidades de detective, entrenamiento físico y una variedad de gadgets, conocido por su lucha contra el crimen sin superpoderes."),
            CharacterItem(13, "Cyborg", "https://i.imgur.com/ztyyv8m.jpeg", "Un héroe con un cuerpo cibernético y habilidades tecnológicas avanzadas, conocido por su capacidad de conectarse a redes digitales y su fortaleza física."),
            CharacterItem(14, "The Flash", "https://i.imgur.com/7VsgvY3.jpeg", "El hombre más rápido del mundo, con la habilidad de moverse a velocidades sobrehumanas y manipular el tiempo."),
            CharacterItem(15, "Green Lantern", "https://i.imgur.com/oQJAsQx.jpeg", "Un miembro del Cuerpo de Linternas Verdes, con un anillo de poder que le permite crear constructos de energía y volar."),
            CharacterItem(16, "Martian Manhunter", "https://i.imgur.com/ZoZhPhg.jpeg", "Un extraterrestre de Marte con habilidades como la telepatía, cambio de forma, y fuerza sobrehumana, conocido por su papel en la Liga de la Justicia."),
            CharacterItem(17, "Robin", "https://i.imgur.com/Cm9dVQy.jpeg", "El joven compañero de Batman, conocido por su habilidad en combate, agilidad y entrenamiento en el arte del crimen."),
            CharacterItem(18, "Shazam", "https://i.imgur.com/wlP3JMq.jpeg", "Un adolescente que puede transformarse en un poderoso héroe con habilidades mágicas al decir '¡Shazam!', con fuerza, velocidad y sabiduría."),
            CharacterItem(19, "Superman", "https://i.imgur.com/qeIh1KW.jpeg", "Un extraterrestre de Krypton con superpoderes como vuelo, visión láser y fuerza sobrehumana, conocido como el Hombre de Acero."),
            CharacterItem(20, "Wonder Woman", "https://i.imgur.com/IoD8cpN.jpeg", "Una guerrera amazona con fuerza divina, habilidades de combate y una variedad de armas míticas, conocida por su lucha por la justicia y la igualdad.")
        )
    }
}