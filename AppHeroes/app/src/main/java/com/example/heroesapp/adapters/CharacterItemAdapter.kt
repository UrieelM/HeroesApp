package com.example.heroesapp.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.activities.HeroDetailActivity
import com.example.heroesapp.models.CharacterItem
import com.squareup.picasso.Picasso

/**
 * Adapter para mostrar una lista de personajes en un RecyclerView.
 * Maneja la visualización de cada ítem y la navegación a HeroDetailActivity al hacer clic.
 */
class CharacterItemAdapter(private val itemList: List<CharacterItem>): RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        // Carga de imagen usando Picasso
        Picasso.get().load(item.imagen).into(holder.itemImage)

        // Configuración del clic en el ítem para abrir HeroDetailActivity
        holder.itemView.setOnClickListener {
            Log.d("CharacterItemAdapter", "Item clicked: ${item.name}")
            val context = holder.itemView.context
            val intent = Intent(context, HeroDetailActivity::class.java)
            intent.putExtra("heroName", item.name)
            intent.putExtra("heroImage", item.imagen)
            intent.putExtra("description", item.descripcion)
            intent.putExtra("heroId", item.id)
            context.startActivity(intent)
        }
    }
}

/**
 * ViewHolder para los ítems del RecyclerView.
 */
class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val itemImage: ImageView = view.findViewById(R.id.item_image)
}