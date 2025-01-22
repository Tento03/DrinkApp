package com.example.drinkapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkapp.R
import com.example.drinkapp.api.Drink
import com.example.drinkapp.databinding.FragmentHomeBinding
import com.example.drinkapp.drink.DrinkAdapter
import com.example.drinkapp.drink.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome:Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentHomeBinding
    lateinit var recyclerView: RecyclerView
    lateinit var drinkAdapter: DrinkAdapter
    private val viewModel by viewModels<DrinkViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentHomeBinding.bind(view)

        recyclerView=binding.rvRandomMeal
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        drinkAdapter= DrinkAdapter(requireContext(),object :DrinkAdapter.onClickListener{
            override fun onItemClick(drink: Drink) {
                var drink=Drink(
                    drink.idDrink, // Handle idDrink
                drink.strDrink ?: "", // Handle strDrink
                drink.strDrinkAlternate ?: "", // Handle strDrinkAlternate
                drink.strTags ?: "", // Handle strTags
                drink.strVideo ?: "", // Handle strVideo
                drink.strCategory ?: "", // Handle strCategory
                drink.strIBA ?: "", // Handle strIBA
                drink.strAlcoholic ?: "", // Handle strAlcoholic
                drink.strGlass ?: "", // Handle strGlass
                drink.strInstructions ?: "", // Handle strInstructions
                drink.strInstructionsES ?: "", // Handle strInstructionsES
                drink.strInstructionsDE ?: "", // Handle strInstructionsDE
                drink.strInstructionsFR ?: "", // Handle strInstructionsFR
                drink.strInstructionsIT ?: "", // Handle strInstructionsIT
                drink.strInstructionsZH_HANS ?: "", // Handle strInstructionsZH_HANS
                drink.strInstructionsZH_HANT ?: "", // Handle strInstructionsZH_HANT
                drink.strDrinkThumb ?: "", // Handle strDrinkThumb
                drink.strIngredient1 ?: "", // Handle strIngredient1
                drink.strIngredient2 ?: "", // Handle strIngredient2
                drink.strIngredient3 ?: "", // Handle strIngredient3
                drink.strIngredient4 ?: "", // Handle strIngredient4
                drink.strIngredient5 ?: "", // Handle strIngredient5
                drink.strIngredient6 ?: "", // Handle strIngredient6
                drink.strIngredient7 ?: "", // Handle strIngredient7
                drink.strIngredient8 ?: "", // Handle strIngredient8
                drink.strIngredient9 ?: "", // Handle strIngredient9
                drink.strIngredient10 ?: "", // Handle strIngredient10
                drink.strIngredient11 ?: "", // Handle strIngredient11
                drink.strIngredient12 ?: "", // Handle strIngredient12
                drink.strIngredient13 ?: "", // Handle strIngredient13
                drink.strIngredient14 ?: "", // Handle strIngredient14
                drink.strIngredient15 ?: "", // Handle strIngredient15
                drink.strMeasure1 ?: "", // Handle strMeasure1
                drink.strMeasure2 ?: "", // Handle strMeasure2
                drink.strMeasure3 ?: "", // Handle strMeasure3
                drink.strMeasure4 ?: "", // Handle strMeasure4
                drink.strMeasure5 ?: "", // Handle strMeasure5
                drink.strMeasure6 ?: "", // Handle strMeasure6
                drink.strMeasure7 ?: "", // Handle strMeasure7
                drink.strMeasure8 ?: "", // Handle strMeasure8
                drink.strMeasure9 ?: "", // Handle strMeasure9
                drink.strMeasure10 ?: "", // Handle strMeasure10
                drink.strMeasure11 ?: "", // Handle strMeasure11
                drink.strMeasure12 ?: "", // Handle strMeasure12
                drink.strMeasure13 ?: "", // Handle strMeasure13
                drink.strMeasure14 ?: "", // Handle strMeasure14
                drink.strMeasure15 ?: "", // Handle strMeasure15
                drink.strImageSource ?: "", // Handle strImageSource
                drink.strImageAttribution ?: "", // Handle strImageAttribution
                drink.strCreativeCommonsConfirmed ?: "", // Handle strCreativeCommonsConfirmed
                drink.dateModified ?: "" // Handle dateModified
                )
                var action=FragmentHomeDirections.actionNavigationHomeToNavigationDetails(drink)
                findNavController().navigate(action)
            }
        })
        recyclerView.adapter=drinkAdapter
       viewModel.randomDrink.observe(viewLifecycleOwner,{
           drinkAdapter.submitData(viewLifecycleOwner.lifecycle,it)
       })
        viewModel.drink.observe(viewLifecycleOwner,{
            drinkAdapter.submitData(viewLifecycleOwner.lifecycle,it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu,menu)
        var searchItem=menu.findItem(R.id.action_search)
        var searchView=searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query!=null){
                    binding.rvRandomMeal.scrollToPosition(0)
                    viewModel.searchDrink(query)
                    drinkAdapter.notifyDataSetChanged()
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

    }
}