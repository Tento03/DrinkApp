package com.example.drinkapp.favorite

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.drinkapp.api.Drink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private var repository: FavoriteRepository):ViewModel() {
    fun addFavorite(drink: Drink){
        CoroutineScope(Dispatchers.IO).launch {
            var favorite=Favorite(
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
                repository.addFavorite(favorite)
        }
    }
    fun getFavorite():LiveData<List<Favorite>>{
        return repository.getFavorite()
    }
    suspend fun getFavoriteId(idDrink: String):Favorite?{
        return repository.getFavoriteId(idDrink)
    }
    fun deleteFavorite(idDrink: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteFavorite(idDrink)
        }
    }
}