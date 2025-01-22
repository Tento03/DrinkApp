package com.example.drinkapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkapp.R
import com.example.drinkapp.api.Drink
import com.example.drinkapp.databinding.FragmentFavoriteBinding
import com.example.drinkapp.databinding.FragmentHomeBinding
import com.example.drinkapp.favorite.Favorite
import com.example.drinkapp.favorite.FavoriteAdapter
import com.example.drinkapp.favorite.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFavorite:Fragment(R.layout.fragment_favorite) {
    lateinit var binding: FragmentFavoriteBinding
    lateinit var favoriteAdapter: FavoriteAdapter
    lateinit var recyclerView: RecyclerView
    private val viewModel by viewModels<FavoriteViewModel>()
    private val favoriteList= arrayListOf<Favorite>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFavoriteBinding.bind(view)

        recyclerView=binding.favRecView
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        favoriteAdapter= FavoriteAdapter(favoriteList,requireContext(),object :FavoriteAdapter.OnItemClickListener{
            override fun onItemClick(favorite: Favorite) {
                var drink= Drink(
                    favorite.idDrink, // Handle idDrink
                    favorite.strDrink ?: "", // Handle strDrink
                    favorite.strDrinkAlternate ?: "", // Handle strDrinkAlternate
                    favorite.strTags ?: "", // Handle strTags
                    favorite.strVideo ?: "", // Handle strVideo
                    favorite.strCategory ?: "", // Handle strCategory
                    favorite.strIBA ?: "", // Handle strIBA
                    favorite.strAlcoholic ?: "", // Handle strAlcoholic
                    favorite.strGlass ?: "", // Handle strGlass
                    favorite.strInstructions ?: "", // Handle strInstructions
                    favorite.strInstructionsES ?: "", // Handle strInstructionsES
                    favorite.strInstructionsDE ?: "", // Handle strInstructionsDE
                    favorite.strInstructionsFR ?: "", // Handle strInstructionsFR
                    favorite.strInstructionsIT ?: "", // Handle strInstructionsIT
                    favorite.strInstructionsZH_HANS ?: "", // Handle strInstructionsZH_HANS
                    favorite.strInstructionsZH_HANT ?: "", // Handle strInstructionsZH_HANT
                    favorite.strDrinkThumb ?: "", // Handle strDrinkThumb
                    favorite.strIngredient1 ?: "", // Handle strIngredient1
                    favorite.strIngredient2 ?: "", // Handle strIngredient2
                    favorite.strIngredient3 ?: "", // Handle strIngredient3
                    favorite.strIngredient4 ?: "", // Handle strIngredient4
                    favorite.strIngredient5 ?: "", // Handle strIngredient5
                    favorite.strIngredient6 ?: "", // Handle strIngredient6
                    favorite.strIngredient7 ?: "", // Handle strIngredient7
                    favorite.strIngredient8 ?: "", // Handle strIngredient8
                    favorite.strIngredient9 ?: "", // Handle strIngredient9
                    favorite.strIngredient10 ?: "", // Handle strIngredient10
                    favorite.strIngredient11 ?: "", // Handle strIngredient11
                    favorite.strIngredient12 ?: "", // Handle strIngredient12
                    favorite.strIngredient13 ?: "", // Handle strIngredient13
                    favorite.strIngredient14 ?: "", // Handle strIngredient14
                    favorite.strIngredient15 ?: "", // Handle strIngredient15
                    favorite.strMeasure1 ?: "", // Handle strMeasure1
                    favorite.strMeasure2 ?: "", // Handle strMeasure2
                    favorite.strMeasure3 ?: "", // Handle strMeasure3
                    favorite.strMeasure4 ?: "", // Handle strMeasure4
                    favorite.strMeasure5 ?: "", // Handle strMeasure5
                    favorite.strMeasure6 ?: "", // Handle strMeasure6
                    favorite.strMeasure7 ?: "", // Handle strMeasure7
                    favorite.strMeasure8 ?: "", // Handle strMeasure8
                    favorite.strMeasure9 ?: "", // Handle strMeasure9
                    favorite.strMeasure10 ?: "", // Handle strMeasure10
                    favorite.strMeasure11 ?: "", // Handle strMeasure11
                    favorite.strMeasure12 ?: "", // Handle strMeasure12
                    favorite.strMeasure13 ?: "", // Handle strMeasure13
                    favorite.strMeasure14 ?: "", // Handle strMeasure14
                    favorite.strMeasure15 ?: "", // Handle strMeasure15
                    favorite.strImageSource ?: "", // Handle strImageSource
                    favorite.strImageAttribution ?: "", // Handle strImageAttribution
                    favorite.strCreativeCommonsConfirmed ?: "", // Handle strCreativeCommonsConfirmed
                    favorite.dateModified ?: "" // Handle dateModified
                )
                var action=FragmentFavoriteDirections.actionNavigationFavoriteToNavigationDetails(drink)
                findNavController().navigate(action)
            }
        })
        recyclerView.adapter=favoriteAdapter
        viewModel.getFavorite().observe(viewLifecycleOwner,{
            favoriteAdapter.setNewList(it)
        })
    }
}