package com.example.myapplication_kts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentRecipes : Fragment(R.layout.fragment_a) {
    class RecipesAdapter(
        val recipes: List<Recipe>,
        val onItemClick: (Recipe) -> Unit,
        val onButtonClick: (Recipe) -> Unit
    ) : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image = itemView.findViewById<ImageView>(R.id.image)
            val title: TextView = itemView.findViewById(R.id.title)
            val likeButton= itemView.findViewById<Button>(R.id.likeButton)

            fun bind(recipe: Recipe) {
                title.text = recipe.title

                itemView.setOnClickListener {
                    onItemClick(recipe)
                }

                likeButton.setOnClickListener {
                    onButtonClick(recipe)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recipe, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(recipes[position])
        }

        override fun getItemCount(): Int = recipes.size
    }
}