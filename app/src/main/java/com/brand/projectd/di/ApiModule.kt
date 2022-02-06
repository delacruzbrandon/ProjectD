package com.brand.projectd.di

import com.brand.projectd.data.repositories.TrackRepository
import com.brand.projectd.data.service.TrackService
import com.brand.projectd.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): TrackService = retrofit.create(TrackService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: TrackService) = TrackRepository(apiService)
}