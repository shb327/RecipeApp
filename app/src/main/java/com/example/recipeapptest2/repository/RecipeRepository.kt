package com.example.recipeapptest2.repository

import com.example.recipeapptest2.model.Recipes
import com.example.recipeapptest2.network.RecipeService
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject constructor(
    private val recipeService: RecipeService
) {

    fun getRecipe(): Single<Recipes> {
        return recipeService.getRecipe()
            .subscribeOn(Schedulers.io())
    }
}