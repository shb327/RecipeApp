package com.example.recipeapptest2.network

import com.example.recipeapptest2.BuildConfig
import com.example.recipeapptest2.model.Recipes
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes/complexSearch?apiKey=${BuildConfig.SPC_KEY}")
    fun getRecipe(): Single<Recipes>


}