package com.brand.projectd.data.service

import com.brand.projectd.data.models.ApiResult
import com.brand.projectd.data.models.Track
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import javax.inject.Singleton

interface TrackService {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun getApiResult(): ApiResult

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    fun getFlowApiResult(): Flow<ApiResult>
}