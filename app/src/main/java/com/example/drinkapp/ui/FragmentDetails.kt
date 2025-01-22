package com.example.drinkapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.drinkapp.R
import com.example.drinkapp.api.Drink
import com.example.drinkapp.databinding.FragmentDetailsBinding
import com.example.drinkapp.databinding.FragmentHomeBinding
import com.example.drinkapp.drink.DrinkViewModel
import com.example.drinkapp.favorite.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FragmentDetails:Fragment(R.layout.fragment_details) {
    lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModels<DrinkViewModel>()
    private val favViewModel by viewModels<FavoriteViewModel>()
    private val args by navArgs<FragmentDetailsArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentDetailsBinding.bind(view)

        binding.imgToolbarBtnBack.setOnClickListener(){
            findNavController().navigate(R.id.action_navigation_details_to_navigation_home)
        }
        var drink=args.drink

        args.drink?.let {
            viewModel.detailDrink(it.idDrink).observe(viewLifecycleOwner) {
                if (drink != null) {
                    Glide.with(requireContext())
                        .load(drink.strDrinkThumb)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(binding.imgItem)
                }
                var ingre = args.drink
                binding.tvCategory.text = args.drink!!.strCategory
                if (ingre != null) {
                    binding.tvIngredients.text =
                        "${ingre.strIngredient1}+${ingre.strIngredient2}+${ingre.strIngredient3}"
                }
                binding.tvInstructions.text = args.drink!!.strInstructions

                binding.btnYoutube.setOnClickListener() {
                    var yt = args.drink!!.strVideo

                    if (!yt.isNullOrBlank()) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(yt))

                        if (intent.resolveActivity(requireContext().packageManager) != null) {
                            startActivity(intent)
                        } else {
                            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(yt))
                            startActivity(webIntent)
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "URL YouTube tidak tersedia",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        var isChecked=false
        CoroutineScope(Dispatchers.IO).launch {
            var count=favViewModel.getFavoriteId(args.drink.idDrink)
            withContext(Dispatchers.Main){
                if (count==null){
                    isChecked=false
                    binding.toggleFavorite.isChecked=false
                }
                else{
                    isChecked=true
                    binding.toggleFavorite.isChecked=true
                }
            }
        }
        binding.toggleFavorite.setOnClickListener(){
            if (isChecked==false){
                binding.toggleFavorite.isChecked=true
                favViewModel.addFavorite(args.drink)
            }
            else{
                binding.toggleFavorite.isChecked=false
                favViewModel.deleteFavorite(args.drink.idDrink)
            }
        }
    }
}