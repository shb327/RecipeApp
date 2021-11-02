package com.example.recipeapptest2.network

import com.example.recipeapptest2.model.Recipes
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes/complexSearch?apiKey=068e1323345442f3a4621a2aebd2919b")
    fun getRecipe(): Single<Recipes>
}