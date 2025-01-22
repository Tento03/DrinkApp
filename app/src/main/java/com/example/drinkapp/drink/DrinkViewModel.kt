package com.example.drinkapp.drink

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.room.util.query
import com.example.drinkapp.api.DrinkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(var repository: DrinkRepository,
private val savedStateHandle: SavedStateHandle):ViewModel() {
    companion object{
        const val DEFAULT_QUERY="margarita"
        const val DEFAULT2_QUERY="cocktail"
        const val CURRENT_QUERY="current"
    }
    private var currentQuery=savedStateHandle.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    var drink=currentQuery.switchMap { query->
        repository.searchDrink(query).cachedIn(viewModelScope)
    }
    var randomDrink=currentQuery.switchMap { query->
        repository.randomDrink().cachedIn(viewModelScope)
    }

    fun searchDrink(s:String){
        currentQuery.value=s
        repository.searchDrink(s)
    }

    fun detailDrink(i:String):LiveData<DrinkResponse> {
        return repository.detailDrink(i)
    }
}