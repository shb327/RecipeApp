package com.example.recipeapptest2.ui.landing

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipeapptest2.model.Recipe
import com.example.recipeapptest2.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel(), LifecycleObserver {

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    init {
         recipeRepository.getRecipe()
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({recipes -> _recipes.value = recipes.results },
                 {t -> Timber.e(t)})

    }

}