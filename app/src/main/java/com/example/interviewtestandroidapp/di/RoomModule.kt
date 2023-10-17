package com.example.interviewtestandroidapp.di

import android.content.Context
import androidx.room.Room
import com.example.interviewtestandroidapp.room.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app : Context
    ) = Room.databaseBuilder(
        app,
        LocalDatabase::class.java,
        "OysterVPN.db"
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideAssociateDrugDao(db: LocalDatabase) = db.getAssociatedDrugDao()

}