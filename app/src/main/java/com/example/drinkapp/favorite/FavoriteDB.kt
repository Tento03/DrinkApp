package com.example.drinkapp.favorite

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteDB:RoomDatabase() {
    abstract fun favoriteDao():FavoriteDao
}