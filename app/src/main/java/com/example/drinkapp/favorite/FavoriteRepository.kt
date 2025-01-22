package com.example.drinkapp.favorite

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepository @Inject constructor(var dao: FavoriteDao) {
    suspend fun addFavorite(favorite: Favorite){
        return dao.addFavorite(favorite)
    }
    fun getFavorite():LiveData<List<Favorite>>{
        return dao.getFavorite()
    }
    suspend fun getFavoriteId(idDrink:String):Favorite?{
        return dao.getFavoriteId(idDrink)
    }
    suspend fun deleteFavorite(idDrink: String):Int{
        return dao.deleteFavorite(idDrink)
    }
}