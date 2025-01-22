package com.example.drinkapp.api

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {
    companion object{
        const val BASE_URL="https://www.thecocktaildb.com/api/json/v1/1/"
    }

    @GET("search.php?")
    suspend fun searchDrink(
        @Query("s")s:String
    ):DrinkResponse

    @GET("random.php")
    suspend fun randomDrink():DrinkResponse

    @GET("search.php?")
    suspend fun searchIngredient(
        @Query("i")i:String
    ):DrinkResponse

    @GET("lookup.php?")
    fun detailDrink(
        @Query("i")i:String
    ):Call<DrinkResponse>
}