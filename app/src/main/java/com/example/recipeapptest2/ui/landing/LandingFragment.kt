package com.example.recipeapptest2.ui.landing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapptest2.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_landing.*

@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.fragment_landing) {

    private lateinit var recipeAdapter: RecipeAdapter

    private val landingViewModel by viewModels<LandingViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeAdapter = RecipeAdapter()
        rvRecipe.layoutManager = LinearLayoutManager(requireContext())
        rvRecipe.adapter = recipeAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        landingViewModel.recipes.observe(viewLifecycleOwner, Observer{
            recipeAdapter.setRecipes(it)
        })
    }
}