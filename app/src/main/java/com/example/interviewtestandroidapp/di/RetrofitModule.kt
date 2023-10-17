package com.example.interviewtestandroidapp.di

import android.provider.SyncStateContract
import com.example.interviewtestandroidapp.Network.APIInterface
import com.example.interviewtestandroidapp.Network.AppServices
import com.example.interviewtestandroidapp.repository.HomeRepository
import com.example.interviewtestandroidapp.util.Constant
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {


    @Provides
    @ViewModelScoped
     fun provideRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val gson = GsonBuilder().setLenient().create()

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constant.MOCK_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    // Games
    @Provides
    @ViewModelScoped
    fun provideApi(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideHomeRepository(appServices: AppServices): HomeRepository {
        return HomeRepository(appServices)
    }

}


