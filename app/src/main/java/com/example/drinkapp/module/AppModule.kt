package com.example.drinkapp.module

import android.content.Context
import androidx.room.Room
import com.example.drinkapp.api.DrinkApi
import com.example.drinkapp.favorite.FavoriteDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit=Retrofit.Builder()
        .baseUrl(DrinkApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun providesDrinkApi(retrofit: Retrofit)=retrofit.create(DrinkApi::class.java)

    @Singleton
    @Provides
    fun providesFavoriteDB(@ApplicationContext app:Context):FavoriteDB=Room.databaseBuilder(
        app,FavoriteDB::class.java,"minuman"
    ).build()

    @Singleton
    @Provides
    fun providesFavoriteDao(db: FavoriteDB)=db.favoriteDao()
}