package com.example.recipeapptest2.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapptest2.R
import com.example.recipeapptest2.glide.GlideApp
import com.example.recipeapptest2.model.Recipe
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var recipes: List<Recipe> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

    }

    fun setRecipes(recipes: List<Recipe>){
        this.recipes = recipes
        notifyDataSetChanged()
    }

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(recipe: Recipe) {
            itemView.apply {
                GlideApp.with(ivImage).load(recipe.image).into(ivImage)
                recipeTitle.text = recipe.title
            }
        }



        companion object{
            fun from(parent: ViewGroup): RecipeViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val itemView = inflater.inflate(R.layout.item_recipe, parent, false)
                return RecipeViewHolder(itemView)
            }
        }
    }
}