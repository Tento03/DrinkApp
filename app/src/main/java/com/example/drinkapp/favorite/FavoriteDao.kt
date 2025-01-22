package com.example.drinkapp.favorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert
    fun addFavorite(favorite: Favorite)

    @Query("SELECT * FROM Drinkss")
    fun getFavorite():LiveData<List<Favorite>>

    @Query("SELECT * FROM Drinkss WHERE idDrink=:idDrink")
    fun getFavoriteId(idDrink:String):Favorite?

    @Query("DELETE FROM Drinkss WHERE idDrink=:idDrink")
    fun deleteFavorite(idDrink: String):Int
}